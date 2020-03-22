package com.openplatform.atf.stepdefs;

import cucumber.api.java.en.Then;

public class ThenStepDefs extends BaseStepDefs {

    @Then("^computer obtains (\\d+) as a result$")
    public void computer_obtains_as_a_result(int arg1) {
        assert context.get("result") == arg1;
    }
}