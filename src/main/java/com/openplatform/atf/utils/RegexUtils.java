package com.openplatform.atf.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class RegexUtils {

    private final static String QUERY_KEYWORD_PATTERN = "\\w+";

    private RegexUtils() {
    }

    public static List<String> extractQueryKeywords(final String queryExpression) {
        List<String> queryKeywords = new ArrayList<>();
        Matcher m = Pattern.compile(QUERY_KEYWORD_PATTERN)
                .matcher(queryExpression);
        while (m.find()) {
            queryKeywords.add(m.group());
        }
        return queryKeywords;
    }
}