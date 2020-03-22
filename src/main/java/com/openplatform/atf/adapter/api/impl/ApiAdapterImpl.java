package com.openplatform.atf.adapter.api.impl;

import com.openplatform.atf.adapter.api.ApiAdapter;
import com.openplatform.atf.domain.model.request.SearchRequest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApiAdapterImpl implements ApiAdapter<Response> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiAdapterImpl.class.getName());

    @Override
    public Response sendRequest(SearchRequest searchSearchRequest) {
        LOGGER.info("Sending {} search request to {} endpoint: ",
                searchSearchRequest.getSearchType().name(), searchSearchRequest.getSearchType().getEndpoint());

        return searchSearchRequest.getRequestSpecification().log().all().get().then().log().all().extract().response();
    }
}