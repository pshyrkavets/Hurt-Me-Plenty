Feature: Amazon search

  Scenario: Searching items on Amazon
    Given I opened Amazon site
    When I search Iphone SE
    And I open item page
    Then Item price is lower than 200


