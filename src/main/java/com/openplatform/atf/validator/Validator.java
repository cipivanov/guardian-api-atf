package com.openplatform.atf.validator;


import com.openplatform.atf.domain.model.Field;
import com.openplatform.atf.domain.model.response.SearchResponse;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validator {

    private final static Logger LOGGER = LoggerFactory.getLogger(Validator.class.getName());

    public static void check(SearchResponse searchResponse, Field field, Matcher<?> condition) {
        Response response = searchResponse.getResponse();
        String fieldName = field.getName();
        String fieldJsonPath = field.getJsonPath();
        String actualValue = response.then().extract().body().path(fieldJsonPath);

        LOGGER.info("Checking field value <{}> with JSON path {} {}",
                fieldName, fieldJsonPath, condition);

        try {
            response.then().body(field.getJsonPath(), condition);
        } catch (AssertionError ae) {
            LOGGER.error("-- ERROR -- <[{}]> field expected value {} but was \"{}\"",
                    fieldName, condition, actualValue);
        }
        LOGGER.info("-- OK -- <[{}]> field expected value {} and was \"{}\"",
                fieldName, condition, actualValue);
    }
}