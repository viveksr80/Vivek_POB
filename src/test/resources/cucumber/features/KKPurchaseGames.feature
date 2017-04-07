@games
Feature: Purchase games

  Scenario: Select and purchase games
    Given I Login to Konkart games store "./testscriptrepository/testdata/TestData.xls"
    When I select games
    And Add games to cart and checkout
    And Edit billing details for games checkout
    Then I should be on the purchase games confirmation page