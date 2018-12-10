Feature: User can list all reading tips

  Scenario: UI prints all reading tips in database
    Given commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected
    Then  the system prints "1 Robert Martin Clean Code: A Handbook of Agile Software Craftsma kirja " and "3 Nicola Apicella Consistency models blogpost " and "4  Merge sort algorithm video " and "2 Margaret Atwood Orjattaresi kirja "