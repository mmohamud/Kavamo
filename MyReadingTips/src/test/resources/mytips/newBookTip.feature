Feature: User can create a new book reading tip

  Scenario: adding a booktip is succsessfull with valid inputs (ISBN 10)
    Given commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected
    When  valid isbn "951-98548-9-4", author "kirjan kirjailija", title "paksu kirja", comment "kiva kirja", summary "jotain jännää"
    Then  the booktip is saved and the system prints "Kirja tallennettu tietokantaan!"

  Scenario: adding a booktip is succsessfull with valid inputs (ISBN 13)
    Given commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected
    When  valid isbn "978-951-98548-9-2", author "kirjailija", title "kirja", comment "kiva kirja", summary "jotain"
    Then  the booktip is saved and the system prints "Kirja tallennettu tietokantaan!"

  Scenario: when adding a booktip the ISBN needs to be valid
    Given commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected
    When  unvalid isbn "123-321-2"
    Then  the system prints "Virheellinen ISBN" and asks to put in the isbn again