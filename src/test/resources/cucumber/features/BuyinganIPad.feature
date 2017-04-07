@buyaniPad
Feature: Buy an iPad
Scenario: John to buy an iPad
    Given John has having a accoutn balance of $2000
    And he has a VISA debit card
    When he swipes the VISA debit card
    Then John should be delivered with an iPad