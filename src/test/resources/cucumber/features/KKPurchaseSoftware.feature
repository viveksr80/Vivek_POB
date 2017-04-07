@software
Feature: Purchase software

  Scenario: Select and purchase Software
    Given I Login to Konkart software store "./testscriptrepository/testdata/TestData.xls"
    When I select software
    And Add software to cart and checkout
    And Edit billing details for software checkout
    Then I should be on the purchase software confirmation page