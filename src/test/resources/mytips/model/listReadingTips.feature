Feature: User can list all reading tips

  Scenario: UI prints all reading tips in database
    Given commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected
    Then  the system prints "kirjoittaja:   Robert Martin" and "kirjoittaja:    Margaret Atwood" and "kirjoittaja:  Nicola Apicella" and "kirjoittaja:   "