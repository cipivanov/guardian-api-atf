package com.openplatform.atf.domain.model;

public enum QueryOperator {

    AND_NOT("AND NOT", "&& !"),
    OR_NOT("OR NOT", "|| !"),
    NOT("NOT", "!"),
    AND("AND", "&&"),
    OR("OR", "||");


    private String value;
    private String javaEquivalent;

    QueryOperator(String value, String javaEquivalent) {
        this.value = value;
        this.javaEquivalent = javaEquivalent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getJavaEquivalent() {
        return javaEquivalent;
    }

    public void setJavaEquivalent(String javaEquivalent) {
        this.javaEquivalent = javaEquivalent;
    }
}