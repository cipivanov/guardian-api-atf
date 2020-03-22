package com.openplatform.atf.validator;


import com.openplatform.atf.domain.model.Field;
import com.openplatform.atf.domain.model.request.SearchRequest;
import com.openplatform.atf.domain.model.response.SearchResponse;
import com.openplatform.atf.evaluator.JaninoEvaluator;
import com.openplatform.atf.utils.QueryUtils;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    public static void checkContent(SearchRequest searchRequest, SearchResponse searchResponse, Field field) {
        Response response = searchResponse.getResponse();
        String fieldName = field.getName();
        String fieldJsonPath = field.getJsonPath();
        List<String> actualValues = response.then().extract().body().path(fieldJsonPath);
        String query = QueryUtils.transform(searchRequest.getQueryParameter());
        for (String actualValue : actualValues) {
            LOGGER.info(actualValue + " -------- " + query + " --------- " + new JaninoEvaluator().evaluateContent(query, actualValue));
        }
    }
}