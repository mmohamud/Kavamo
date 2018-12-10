Feature: User can create a new book reading tip

  Scenario: adding a booktip is succsessfull with valid inputs
    Given commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected
    When  valid isbn "951-98548-9-4", author "kirjan kirjailija", title "paksu kirja", comment "kiva kirja", summary "jotain jännää", readStatus "false" are given
    And command lopeta is selected
    Then  the booktip is saved and the system prints "Lukuvinkki tallennettu!"


