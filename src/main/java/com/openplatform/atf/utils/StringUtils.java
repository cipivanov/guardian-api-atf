package com.openplatform.atf.utils;

import java.util.List;

@Deprecated
public final class StringUtils {

    private final static String QUERY_KEYWORD_REGEX = "(\\w+)";
    private final static String QUERY_KEYWORD_SUBSTITUTION = "content.contains(\"keyWord\")";

    private StringUtils() {
    }

    public static String substituteQueryKeywords(final String queryExpression) {
        return queryExpression.replaceAll(QUERY_KEYWORD_REGEX, QUERY_KEYWORD_SUBSTITUTION);
    }

    public static String repopulateQueryKeywords(final List<String> queryKeywords, final String queryExpression) {
        String transformedQueryExpression = queryExpression;
        for (String keyWord : queryKeywords) {
            transformedQueryExpression = transformedQueryExpression.replaceFirst("keyWord", keyWord);
        }
        return transformedQueryExpression;
    }

    public static String substituteDefaultOperatorsIfPresent(final String queryExpression) {
        return queryExpression.replaceAll("\\)(\\s+)content", ") || content");
    }
}