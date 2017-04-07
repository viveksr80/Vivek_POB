@iPhone
Feature: Purchase iPhone

  Scenario: Select and purchase an iPhone
    Given I am on store website "./testscriptrepository/testdata/TestData.xls"
    When I select iPhone from Product Category
    And Add iPhone to cart and Checkout
    And Provide billing details and shipping address for iPhone checkout
    Then I should be on the Purchase iPhone confirmation page