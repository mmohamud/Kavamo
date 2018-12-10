Feature: User can print all the info from a readingtip

  Scenario: User searches for a readingtip with a valid id
    Given commands selaa lukuvinkkejä and näytä yhden lukuvinkin tarkat tiedot are selected
    When  valid id "1" is given and command palaa alkuun is selected
    And command lopeta is selected
    Then  all the details from the readingtip are printed