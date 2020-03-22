package com.openplatform.atf.utils;

import com.openplatform.atf.domain.model.QueryOperator;
import cucumber.api.java.hu.De;

import java.util.List;

import static com.openplatform.atf.utils.RegexUtils.extractQueryKeywords;
import static com.openplatform.atf.utils.StringUtils.*;

@Deprecated
public final class QueryUtils {

    private QueryUtils() {
    }

    public static String transform(final String queryExpression) {
        String transformedQueryExpression = substituteLogicalOperators(queryExpression);
        transformedQueryExpression = substituteKeywords(transformedQueryExpression);

        return handleDefaultOperators(transformedQueryExpression);
    }

    private static String substituteLogicalOperators(final String queryExpression) {
        String transformedQueryExpression = queryExpression;
        for (QueryOperator queryOperator : QueryOperator.values()) {
            transformedQueryExpression = transformedQueryExpression.replaceAll(queryOperator.getValue(), queryOperator.getJavaEquivalent());
        }

        return transformedQueryExpression;
    }

    private static String substituteKeywords(final String queryExpression) {
        List<String> queryKeywords = extractQueryKeywords(queryExpression);
        String transformedQueryExpression = substituteQueryKeywords(queryExpression);

        return repopulateQueryKeywords(queryKeywords, transformedQueryExpression);
    }


    private static String handleDefaultOperators(final String queryExpression) {
        return substituteDefaultOperatorsIfPresent(queryExpression);
    }
}