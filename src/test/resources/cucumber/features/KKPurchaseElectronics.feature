@electronics
Feature: Purchase electronics

  Scenario: Select and purchase electronics
    Given I Login to Konkart electronics store "./testscriptrepository/testdata/TestData.xls"
    When I select electronics
    And Add electronics to cart and checkout
    And Edit billing details for electronics checkout
    Then I should be on the purchase electronics confirmation page