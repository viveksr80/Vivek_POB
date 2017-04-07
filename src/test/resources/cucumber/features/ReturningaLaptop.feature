@returnLaptop
Feature: Return a Laptop
Scenario: Jacob returns a faulty Laptop
    Given Jacob has bought a Laptop for $800
    And he has a receipt for the laptop purchase
    When he returns the laptop
    Then Jacob should be refunded $800