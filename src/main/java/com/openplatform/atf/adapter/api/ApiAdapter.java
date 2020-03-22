package com.openplatform.atf.adapter.api;

import com.openplatform.atf.domain.model.request.SearchRequest;

public interface ApiAdapter<T> {

    T sendRequest(SearchRequest searchSearchRequest);
}