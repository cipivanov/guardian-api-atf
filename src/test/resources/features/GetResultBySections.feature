Feature: Supply response when content search performed

  Scenario: A client makes a sections search on Open Platform Guardian API
    Given a client has a valid SECTIONS search prepared
    When client makes the search request
    Then client receives a valid response