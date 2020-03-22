package com.openplatform.atf.domain.model.request;

import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class SearchRequest {

    @Value("${atf.api.base.uri}")
    private String baseUri;

    @Value("${atf.api.key}")
    private String apiKey;
    private SearchType searchType;
    private RequestSpecification requestSpecification;

    public String getBaseUri() {
        return baseUri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification =
                    given().
                            baseUri(baseUri).
                            basePath(searchType.getEndpoint()).
                            param("api-key", apiKey);
        }

        return requestSpecification;
    }
}