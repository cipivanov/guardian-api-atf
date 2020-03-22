package com.openplatform.atf.domain.model.request;

public enum Status {

    OK("ok"),
    ERROR("error");

    Status(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}