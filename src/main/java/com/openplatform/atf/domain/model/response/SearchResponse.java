package com.openplatform.atf.domain.model.response;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public final class SearchResponse {

    private Response response;
    private SearchResponseBody searchResponseBody;

    public void setResponse(Response response) {
        this.response = response;
        searchResponseBody = response.as(SearchResponseBody.class);
    }

    public SearchResponseBody getSearchResponseBody() {
        return searchResponseBody;
    }

    public Response getResponse() {
        return response;
    }
}