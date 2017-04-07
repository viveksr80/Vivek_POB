@BloodVolumeCalc
Feature: Calculate BloodVolume
  Scenario: Calculating BloodVolume for a person
    Given I am on the HealtCalculator App for BloodVolume calc "./testscriptrepository/testdata/TestData.xls"
    When I select BloodVolume from the options
    And I provided the necessary details for BloodVolume calc and clicked Calculate
    Then I should see the calculated BloodVolume result