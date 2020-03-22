package com.openplatform.atf.evaluator;

import java.util.function.BiPredicate;

public enum EvaluationType {

    CONTAINS(String::contains),
    MATCHES(String::matches),
    EQUALS(String::equals);

    private BiPredicate<String, String> predicate;

    EvaluationType(BiPredicate<String, String> predicate) {
        this.predicate = predicate;
    }

    public BiPredicate<String, String> getPredicate() {
        return predicate;
    }
}