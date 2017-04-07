@buyaniPhone
Feature: Buy an iPhone
Scenario: John to buy an iPhone
    Given John has having a accoutn balance of $1000
    And he has a debit card
    When he swipes the card
    Then John should be delivered with an iPhone