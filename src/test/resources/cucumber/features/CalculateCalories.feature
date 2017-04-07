@CaloriesCalc
Feature: Calculate Calories
  Scenario: Calculating Calories for a person
    Given I am on the HealtCalculator App for Calories calc "./testscriptrepository/testdata/TestData.xls"
    When I select Calories from the options
    And I provided the necessary details for Calories calc and clicked Calculate
    Then I should see the calculated Calories result