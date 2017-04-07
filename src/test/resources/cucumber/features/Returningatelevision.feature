@returnTV
Feature: Return a television
Scenario: Immanuel returns a faulty television
    Given Immanuel has bought a television for $550
    And he has a receipt for the television purchase
    When he returns the television
    Then Immanuel should be refunded $550