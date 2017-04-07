@homeandgarden
Feature: Purchase homeandgarden

  Scenario: Select and purchase homeandgarden
    Given I Login to Konkart homeandgarden store "./testscriptrepository/testdata/TestData.xls"
    When I select homeandgarden
    And Add homeandgarden to cart and checkout
    And Edit billing details for homeandgarden checkout
    Then I should be on the purchase homeandgarden confirmation page