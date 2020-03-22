package com.openplatform.atf.domain.model;

public enum Field {

    STATUS("status", "response.status"),
    BODY_TEXT("bodyText", "response.results.fields.bodyText"),
    SECTION("section", "response.results.id");

    private String name;
    private String jsonPath;

    Field(String name, String jsonPath) {
        this.name = name;
        this.jsonPath = jsonPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }
}