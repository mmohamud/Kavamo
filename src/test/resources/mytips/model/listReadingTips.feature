Feature: User can list all reading tips

  Scenario: UI prints all reading tips in database
    Given commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected
    Then  the system prints "Robert Martin Clean Code: A Handbook of Agile Software Craftsmanship kirja" and "Margaret Atwood Orjattaresi kirja" and "Nicola Apicella Consistency models blogpost" and " Merge sort algorithm video"