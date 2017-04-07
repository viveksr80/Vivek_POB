@buyinganiMac
Feature: Buy an iMac
Scenario: John to buy an iMac
    Given John has having a accoutn balance of $3000
    And he has a Mastero debit card
    When he swipes the Mastero debit card
    Then John should be delivered with an iMac