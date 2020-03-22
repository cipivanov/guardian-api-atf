Feature: Supply response when content search performed

# Test based on the validation of content make the assumption which for some cases result in assertion failure.
# Since not always the keyword is contained in teh article/blog/live itself

  Scenario: A client searches all content on Open Platform Guardian API
    Given a client has a valid CONTENT search prepared
    And searches for football
    And filters by
      | show-fields | bodyText |
    When client makes the search request
    Then client receives a valid response
    And client receives a response with expected content

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
    When client makes the search request
    Then client receives a valid response

  Scenario: A client searches all content on Open Platform Guardian API
    Given a client has a valid CONTENT search prepared
    And searches for debate AND (economy OR immigration OR education)
    And filters by
      | show-fields | bodyText |
    When client makes the search request
    Then client receives a valid response
    And client receives a response with expected content