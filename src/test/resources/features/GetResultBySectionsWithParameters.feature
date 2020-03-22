Feature: Supply response when content search performed

  Scenario: A client searches all sections on Open Platform Guardian API
    Given a client has a valid SECTIONS search prepared
    When client makes the search request
    Then client receives a valid response

  Scenario: A client searches a section on Open Platform Guardian API
    Given a client has a valid SECTIONS search prepared
    And searches for football
    When client makes the search request
    Then client receives a valid response
    And client receives a response with expected section