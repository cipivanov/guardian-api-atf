package com.openplatform.atf.validator.impl;

import com.openplatform.atf.domain.model.response.Field;
import com.openplatform.atf.domain.model.response.SearchResponse;
import com.openplatform.atf.evaluator.EvaluationType;
import com.openplatform.atf.utils.EvalUtils;
import com.openplatform.atf.validator.Validator;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidatorImpl implements Validator {

    private final static Logger LOGGER = LoggerFactory.getLogger(com.openplatform.atf.validator.impl.ValidatorImpl.class.getName());

    @Override
    public Boolean validate(SearchResponse searchResponse, Field field, Matcher<?> condition) {
        Response response = searchResponse.getResponse();
        String fieldName = field.getName();
        String fieldJsonPath = field.getJsonPath();
        String actualValue = response.then().extract().body().path(fieldJsonPath);

        LOGGER.info("Checking field value <{}> with JSON path {} {}",
                fieldName, fieldJsonPath, condition);

        try {
            response.then().body(field.getJsonPath(), condition);
        } catch (AssertionError ae) {
            LOGGER.error("-- FAILURE -- <[{}]> field expected value {} but was \"{}\"",
                    fieldName, condition, actualValue);
            return false;
        }
        LOGGER.info("-- OK -- <[{}]> field expected value {} and was \"{}\"",
                fieldName, condition, actualValue);
        return true;
    }

    @Override
    public Boolean validateContentOf(SearchResponse searchResponse, EvaluationType evaluationType, String query) {
        Response response = searchResponse.getResponse();
        String fieldName = Field.BODY_TEXT.getName();
        String fieldJsonPath = Field.BODY_TEXT.getJsonPath();
        List<String> actualValues = response.then().extract().body().path(fieldJsonPath);

        LOGGER.info("Checking content of field <{}> with JSON path {} corresponds to query {}",
                fieldName, fieldJsonPath, query);

        if (EvalUtils.evaluate(actualValues, evaluationType, query)) {
            LOGGER.info("-- OK -- Content of fields <{}> with JSON path {} does correspond to to query {}",
                    fieldName, fieldJsonPath, query);
            return true;
        } else {
            LOGGER.info("-- FAILURE -- Content of fields <{}> with JSON path {} does not correspond to to query {}",
                    fieldName, fieldJsonPath, query);
            return false;
        }
    }


    public Boolean validateSectionOf(SearchResponse searchResponse, EvaluationType evaluationType, String query) {
        Response response = searchResponse.getResponse();
        String fieldName = Field.SECTION.getName();
        String fieldJsonPath = Field.SECTION.getJsonPath();
        List<String> actualValues = response.then().extract().body().path(fieldJsonPath);

        LOGGER.info("Checking content of field <{}> with JSON path {} corresponds to query {}",
                fieldName, fieldJsonPath, query);

        Boolean result = EvalUtils.evaluate(actualValues, evaluationType, query);

        if (result) {
            LOGGER.info("-- OK -- Content of fields <{}> with JSON path {} does correspond to to query {}",
                    fieldName, fieldJsonPath, query);
        } else {
            LOGGER.info("-- FAILURE -- Content of fields <{}> with JSON path {} does not correspond to to query {}",
                    fieldName, fieldJsonPath, query);
        }
        return result;
    }
}