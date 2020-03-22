package com.openplatform.atf.stepdefs;

import com.openplatform.atf.adapter.api.impl.ApiAdapterImpl;
import com.openplatform.atf.domain.model.request.SearchRequest;
import com.openplatform.atf.domain.model.request.SearchType;
import com.openplatform.atf.domain.model.response.SearchResponse;
import com.openplatform.atf.validator.Validator;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.openplatform.atf.domain.model.Field.STATUS;
import static com.openplatform.atf.domain.model.request.Status.OK;
import static com.openplatform.atf.evaluator.EvaluationType.CONTAINS;
import static com.openplatform.atf.evaluator.EvaluationType.EQUALS;
import static com.openplatform.atf.validator.Validator.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchContentStepDefs {

    private final static Logger LOGGER = LoggerFactory.getLogger(Validator.class.getName());

    @Autowired
    protected ApiAdapterImpl guardianApiAdapter;

    @Autowired
    protected SearchRequest searchRequest;

    @Autowired
    protected SearchResponse searchResponse;

    @Before
    public void setup() {
        LOGGER.info("Started running feature");
    }

    @After
    public void tearDown() {
        LOGGER.info("Stopped running feature");
    }

    @Given("^a (.*) has a valid (CONTENT|SECTIONS) search prepared$")
    public void clientHasAValidSearchPrepared(String actor, String searchType) {
        searchRequest.setSearchType(SearchType.valueOf(searchType));
    }

    @When("^(.*) makes the search request$")
    public void clientMakesTheSearchRequest(String actor) {
        searchResponse.setResponse(guardianApiAdapter.sendRequest(searchRequest));
    }

    @Then("^(.*) receives a valid response$")
    public void receivesAValidResponse(String actor) {
        assertThat(check(searchResponse, STATUS, is(OK.getValue())), is(true));
    }

    @Deprecated
    @Then("^(.*) receives a response with expected content$")
    public void receivesAResponseWithExprectedContentAlternative(String actor) {
        assertThat(checkContentOf(searchResponse, CONTAINS, searchRequest.getQuery()), is(true));
    }

    @And("^searches for (.*)$")
    public void searchesFor(String queryParameter) {
        searchRequest.setQueryParameter(queryParameter);
    }

    @And("^filters by$")
    public void filtersBy(Map<String, String> filters) {
        searchRequest.setFilters(filters);
    }

    @And("^(.*) receives a response with expected section$")
    public void clientReceivesAResponseWithExpectedSection(String actor) {
        assertThat(checkSectionOf(searchResponse, EQUALS, searchRequest.getQuery()), is(true));
    }
}