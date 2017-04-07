@AceLaptop
Feature: Purchase Ace Laptop
  Scenario: Select and purchase an Laptop
    Given I am on website in mobile "./testscriptrepository/testdata/TestData.xls"
    When I select Laptop from Electronic Category in mobile
    And Add Laptop to cart and Checkout in mobile
    And Provide billing details and shipping address for Laptop checkout in mobile
    Then I should be on the purchase confirmation page in mobile