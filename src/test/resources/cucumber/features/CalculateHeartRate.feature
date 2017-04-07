@HeartRateCalc
Feature: Calculate BMI
  Scenario: Calculating HeartRate for a person
    Given I am on the HealtCalculator App for HeartRate calc "./testscriptrepository/testdata/TestData.xls"
    When I select HeartRate from the options
    And I provided the necessary details for HeartRate calc and clicked Calculate
    Then I should see the calculated HeartRate result