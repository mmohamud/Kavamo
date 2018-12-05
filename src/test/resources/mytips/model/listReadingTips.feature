Feature: User can list all reading tips

  Scenario: UI prints all reading tips in database
    Given commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected
    Then  the system prints "20 Robert Martin Clean Code: A Handbook of Agile Software Craftsmanship kirja" and "21 Margaret Atwood Orjattaresi kirja" and "10 Nicola Apicella Consistency models blogpost" and "11  Merge sort algorithm video"
