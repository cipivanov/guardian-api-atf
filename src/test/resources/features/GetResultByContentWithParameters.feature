Feature: Supply response when content search performed

  Scenario: A client searches all content on Open Platform Guardian API
    Given a client has a valid CONTENT search prepared
    And searches for football AND tennis
    And filters by
      | order-by | newest |
    When client makes the search request
    Then client receives a valid response


  Scenario: A client searches all content on Open Platform Guardian API
    Given a client has a valid CONTENT search prepared
    And searches for football OR tennis
    And filters by
      | order-by | oldest |
    When client makes the search request
    Then client receives a valid response