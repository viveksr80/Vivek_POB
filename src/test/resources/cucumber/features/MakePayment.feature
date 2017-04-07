@ABCBank
Feature: Make a payment through netbanking

  Scenario: Payment through Netbanking
    Given I am in ABC bank site
    When I login and select the payment option in ABC
    Then I should be able to do payment from ABC bank