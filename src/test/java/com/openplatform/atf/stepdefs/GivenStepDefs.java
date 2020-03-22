package com.openplatform.atf.stepdefs;

import cucumber.api.java.en.Given;

public class GivenStepDefs extends BaseStepDefs {

    @Given("^user provides numbers (\\d+) and (\\d+)$")
    public void user_provides_numbers_and(int arg1, int arg2) throws Throwable {
        System.out.println("Numbers provided: " + arg1 + " and " + arg2);
        context.put("1", arg1);
        context.put("2", arg2);
    }
}