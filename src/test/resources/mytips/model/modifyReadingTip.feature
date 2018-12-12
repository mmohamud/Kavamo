Feature: User can modify existing reading tip

    Scenario: User changes the status of an unread reading tip to read
    Given commands hallinnoi lukuvinkkejä (1) and muokkaa lukuvinkkiä (2) are selected
    When an existing id "1" is given
    And the field to be modified "status" is given
    And commands lopeta (q), palaa alkuun (4) and lopeta (3) are selected
    Then the system prints "Status:  Luettu "