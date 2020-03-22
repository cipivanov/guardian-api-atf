package com.openplatform.atf.utils;

import com.openplatform.atf.evaluator.EvaluationType;
import com.openplatform.atf.evaluator.TextualBooleanEvaluator;

import java.util.List;

public final class EvalUtils {

    private EvalUtils() {
    }

    public static Boolean evaluate(final List<String> values, final EvaluationType type, final String query) {
        // not very Spring-like, I know
        TextualBooleanEvaluator textualBooleanEvaluator = new TextualBooleanEvaluator(type);

        return values.stream().allMatch(bodyText -> textualBooleanEvaluator.evaluate(query, bodyText));
    }
}