Feature: User can list all reading tips

  Scenario: UI prints all reading tips in database
    Given commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected
    Then  the system prints "0 Robert Martin Clean Code: A Handbook of Agile Software Craftsmanship kirja " and "0 Nicola Apicella Consistency models blogpost " and "0  Merge sort algorithm video " and "0 Margaret Atwood Orjattaresi kirja "