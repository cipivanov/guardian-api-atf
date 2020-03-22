package com.openplatform.atf.domain.model.request;

public enum SearchType {

    CONTENT("/search"),
    SECTIONS("/sections");

    SearchType(String endpoint) {
        this.endpoint = endpoint;
    }

    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }
}