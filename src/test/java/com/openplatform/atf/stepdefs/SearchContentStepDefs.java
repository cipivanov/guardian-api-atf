package com.openplatform.atf.stepdefs;

import com.openplatform.atf.adapter.api.impl.ApiAdapterImpl;
import com.openplatform.atf.domain.model.request.SearchRequest;
import com.openplatform.atf.domain.model.request.SearchType;
import com.openplatform.atf.domain.model.response.SearchResult;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchContentStepDefs {

    @Autowired
    private ApiAdapterImpl apiAdapter;

    @Autowired
    private SearchRequest searchRequest;

    @Autowired
    private SearchResult searchResponse;

    @Given("^(.*) has a valid (CONTENT|SECTIONS) search prepared$")
    public void client_has_a_valid_request_prepared(String actor, String searchType) {
        searchRequest.setSearchType(SearchType.valueOf(searchType));
    }

    @When("^(.*) makes a search request$")
    public void client_request_the_content(String actor) {
        searchResponse.setResponse(apiAdapter.sendRequest(searchRequest));
    }

    @Then("^(.*) receives a valid response$")
    public void response_is_returned(String actor) {
        assert searchResponse.getResponse().statusCode() == 200;
    }
}