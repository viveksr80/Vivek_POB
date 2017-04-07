Feature: Banking Login Action

Scenario: Using test data from excel for Cucumber tests
When I open Banking web site
And I enter test data from "./data/TestData.xlsx" and SignIn
Then I go to Banking site home page

Scenario: Create Prospect
When I go to Create Prospect page by clicking on Input Prospect
And I enter GB Name from data file "./data/TestData.xlsx"
And I commit the deal
Then I go to Banking home page

Scenario: Amend Prospect
When I go to Amend Prospect page by clicking on Amend Person records
And I enter Name from data file "./data/TestData.xlsx"
And I Find
Then I go to Amend search page