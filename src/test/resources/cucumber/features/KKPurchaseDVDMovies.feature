@dvdmovies
Feature: Purchase dvdmovies

  Scenario: Select and purchase dvdmovies
    Given I Login to Konkart dvdmovies store "./testscriptrepository/testdata/TestData.xls"
    When I select dvdmovies
    And Add dvdmovies to cart and checkout
    And Edit billing details for dvdmovies checkout
    Then I should be on the purchase dvdmovies confirmation page