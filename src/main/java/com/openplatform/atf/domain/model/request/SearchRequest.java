package com.openplatform.atf.domain.model.request;

import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Component
@Scope("prototype")
public class SearchRequest {

    @Value("${atf.api.base.uri}")
    private String baseUri;

    @Value("${atf.api.key}")
    private String apiKey;

    @Value("${atf.api.query.parameter}")
    private String queryParameterKey;
    private SearchType searchType;
    private Map<String, String> parameters;
    private RequestSpecification requestSpecification;

    public SearchRequest() {
        parameters = new HashMap<>();
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setQueryParameter(String queryParameter) {
        this.parameters.put(queryParameterKey, queryParameter);
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification =
                    given().
                            baseUri(baseUri).
                            basePath(searchType.getEndpoint()).
                            param("api-key", apiKey).
                            params(parameters);
        }

        return requestSpecification;
    }

    public void setFilters(Map<String, String> parameters) {
        this.parameters.putAll(parameters);
    }
}