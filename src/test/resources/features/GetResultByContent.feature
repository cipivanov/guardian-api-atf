Feature: Supply response when content search performed

  Scenario: A client makes a content search on Open Platform Guardian API
    Given a client has a valid CONTENT search prepared
    When client makes the search request
    Then client receives a valid response