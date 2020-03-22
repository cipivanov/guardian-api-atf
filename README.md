# Guardian Open Platform API Test Automation Framework

### Current CI status: [![Build Status](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test.svg?branch=master)](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test)

This repository contains a test automation framework for Guardian Open Platform API.

Visit : [http://open-platform.theguardian.com/]()

## Languages, frameworks and libraries used

* *Java:* programming language of choice
* *Spring:* more specifically Spring Core, provides the .properties file property loading and dependency injection
* *Cucumber:* BDD style framework integrated with Spring
* *Maven:* dependency management and build tool
* *Logback:* provides the logging capabilities
* *REST-assured:* REST services testing framework
* *Gson:* complementary library for REST-assured to allow JSON messages unmarshalling
* *Javaluator:* enables the test automation framework to interpret textual boolean queries

## Project structure

The ATF core has the following structure:
src\main\java\com\openplatform\atf
```
src
└─main
   └─java
   │  └─com
   │     └─openplatform
   │        └─atf
   │           └─adapter   - contains the API Adapter layer
   │           └─domain    - domain specific models
   │           └─evaluator - textual logical expressions evaluator
   │           └─utils     - utility classes
   │           └─validator - validation layer where all the checks occur
   └─resources - currently has only the atf.properties file
```
*.travis.yml* - the manages the Travis CI plugin and the jobs triggered
*pom.xml* - handles all the dependencies and information about the build process

The "entry" point of the framework, the Cucumber .feature files are located in
*src\test\resources\features*

Step definitions can be found in *src\test\java\com\openplatform\atf\stepdefs*

Cucumber Runner *src\test\java\com\openplatform\atf\runner*

## Setup

Not much in the way of setting up the project.

The only requirement is to have Maven installed and configured properly. See: https://maven.apache.org/install.html
Then Maven should handle all the dependencies by itself.

## Current capabilities

Bare-bones test framework structure created and is includes perform the following:

1. Define BDD style scenarios using Gherkin syntax
2. Make REST service API request
3. Un-marshal and check response obtained
4. Allows integration into CI/CD pipeline
4. Provide basic test evidence via logs

## TODO's

* Custom reporting capabilities
    * Showcase what is being tested and the value of the tests being run to non-technical people.
    * Test evidence (more in-depth extensive test run logs) gathering is also being developed
* Extension and re-factoring of the validation capabilities
    * The goal is allow a multitude of validation capabilities coupled with reduction in boilerplate code.
    * Current validations are based on assumptions about the content and this result in some test cases failing
* Multi-page results search and validation
* Parallel execution capabilities (likely implies extensive re-factoring)

