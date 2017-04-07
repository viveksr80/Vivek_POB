@returniPhone
Feature: Return an iPHone
Scenario: Johanna returns a faulty iPhone
    Given Johanna has bought an iPhone for $900
    And he has a receipt for the iPhone purchase
    When he returns the iPhone
    Then Johanna should be refunded $900