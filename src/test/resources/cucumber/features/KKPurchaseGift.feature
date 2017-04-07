@gift
Feature: Purchase gift

  Scenario: Select and purchase gift
    Given I Login to Konkart gift store "./testscriptrepository/testdata/TestData.xls"
    When I select gift
    And Add gift to cart and checkout
    And Edit billing details for gift checkout
    Then I should be on the purchase gift confirmation page