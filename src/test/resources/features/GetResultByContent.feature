Feature: Supply response when content search performed

  Scenario: User searches all content on Open Platform Guardian API
    Given Client has a valid CONTENT search prepared
    When Client makes a search request
    Then Client receives a valid response