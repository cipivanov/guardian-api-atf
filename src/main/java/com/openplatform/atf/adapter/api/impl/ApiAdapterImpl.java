package com.openplatform.atf.adapter.api.impl;

import com.openplatform.atf.adapter.api.ApiAdapter;
import com.openplatform.atf.domain.model.request.SearchRequest;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class ApiAdapterImpl implements ApiAdapter<Response> {

    @Override
    public Response sendRequest(SearchRequest searchSearchRequest) {
        Response response = searchSearchRequest.getRequestSpecification().log().all().get();
        response.then().log().all();

        return response;
    }
}