package com.openplatform.atf.stepdefs;

import cucumber.api.java.en.When;

public class WhenStepDefs extends BaseStepDefs {

    @When("^computer adds the numbers received$")
    public void computer_adds_the_numbers_received() {
        context.put("result", context.get("1") + context.get("2"));
    }
}