Feature: User can print all the info from a readingtip

  Scenario: User searches for a readingtip with a valid id
    Given commands selaa lukuvinkkejä and näytä yhden lukuvinkin tarkat tiedot are selected
    When  valid id "1" is given
    And commands palaa alkuun ja lopeta are selected 
    Then  all the details from the readingtip are printed

  Scenario: User searches for a non-existing reading tip
    Given commands selaa lukuvinkkejä and näytä yhden lukuvinkin tarkat tiedot are selected
    When non-existing id "101" is given
    And command palaa edelliseen valikkoon is given
    And commands palaa alkuun ja lopeta are selected 
    Then the system prints "Lukuvinkkiä ei löytynyt antamallasi id:llä"