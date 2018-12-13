Feature: User can list all reading tips by status

  Scenario: UI prints all reading tips marked as not read
    Given commands selaa lukuvinkkejä (2) and listaa lukuvinkit statuksen mukaan (3) and lukemattomat (2) are selected
    When commands palaa alkuun (5) and lopeta (3) are selected 
    Then  the system prints "1 Robert Martin Clean Code: A Handbook of Agile Software Craftsma kirja Ei luettu " and "3 Nicola Apicella Consistency models blogi Ei luettu " and "4  Merge sort algorithm video Ei luettu " and "2 Margaret Atwood Orjattaresi kirja Ei luettu "

  Scenario: UI prints all reading tips marked as read
    Given commands selaa lukuvinkkejä (2) and listaa lukuvinkit statuksen mukaan (3) and luetut (2) are selected
    When commands palaa alkuun (5) and lopeta (3) are selected 
    Then  the system prints "5 Mika Waltari Sinuheyptiläinen kirja Luettu "