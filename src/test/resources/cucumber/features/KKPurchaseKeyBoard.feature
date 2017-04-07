@keyboard
Feature: Purchase keyboard

  Scenario: Select and purchase keyboard
    Given I Login to Konkart keyboard store "./testscriptrepository/testdata/TestData.xls"
    When I select keyboard
    And Add keyboard to cart and checkout
    And Edit billing details for keyboard checkout
    Then I should be on the purchase keyboard confirmation page