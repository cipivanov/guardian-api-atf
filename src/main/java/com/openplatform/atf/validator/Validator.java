package com.openplatform.atf.validator;

import com.openplatform.atf.domain.model.response.Field;
import com.openplatform.atf.domain.model.response.SearchResponse;
import com.openplatform.atf.evaluator.EvaluationType;
import org.hamcrest.Matcher;

public interface Validator {

    Boolean validate(SearchResponse searchResponse, Field field, Matcher<?> condition);

    Boolean validateContentOf(SearchResponse searchResponse, EvaluationType evaluationType, String query);

    Boolean validateSectionOf(SearchResponse searchResponse, EvaluationType evaluationType, String query);
}