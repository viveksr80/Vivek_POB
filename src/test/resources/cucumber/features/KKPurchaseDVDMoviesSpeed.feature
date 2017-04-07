@dvdmoviesspeed
Feature: Purchase dvdmovies speed

  Scenario: Select and purchase dvdmovies
    Given I Login to Konakart dvdmovies store "./testscriptrepository/testdata/TestData.xls"
    When I select dvdmovies Speed
    And Add dvdmovie speed to cart and checkout
    And Edit billing details for the movies speed and checkout
    Then I should be on the purchase dvdmovies speed and confirmation page