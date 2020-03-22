package com.openplatform.atf.domain.model.response;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public final class SearchResult {

    private Response response;
    private SearchResultBody searchResultBody;

    public void setResponse(Response response) {
        this.response = response;
        searchResultBody = response.as(SearchResultBody.class);
    }

    public SearchResultBody getSearchResultBody() {
        return searchResultBody;
    }

    public Response getResponse() {
        return response;
    }
}