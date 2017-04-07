@buyingSurfaceBook
Feature: Buy a SurfaceBook
Scenario: John to buy a SurfaceBook
    Given John has having a accoutn balance of $7500
    And he has a VISA credit card
    When he swipes the VISA credit card
    Then John should be delivered with the Surface Book