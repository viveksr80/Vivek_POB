@iMac
Feature: Purchase iMac
  Scenario: Select and purchase an iMac
    Given I am on website "./testscriptrepository/testdata/TestData.xls"
    When I select iMac from Product Category
    And Add iMac to cart and Checkout
    And Provide billing details and shipping address for iMac checkout
    Then I should be on the Purchase iMac confirmation page