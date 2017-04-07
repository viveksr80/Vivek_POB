@BMICalc
Feature: Calculate BMI
  Scenario: Calculating BMI for a person
    Given I am on the HealtCalculator App "./testscriptrepository/testdata/TestData.xls"
    When I select BMI from the options
    And I provided the necessary details and clicked Calculate
    Then I should see the calculated BMI result