@BMICalcTest
Feature: Calculate BMI Test
  Scenario: Calculating BMI Test for a person
    Given I am on the HealtCalculator App Test "./testscriptrepository/testdata/TestData.xls"
    When I select BMI from the options Test
    And I provided the necessary details and clicked Calculate Test
    Then I should see the calculated BMI result Test