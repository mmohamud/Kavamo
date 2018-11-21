Feature: User can create a new book reading tip

    Scenario: creation is successful with valid username and password
        Given commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected
        When  isbn "123456", author "kirjailija", title "kirja", comment "kiva kirja",
                summary "jotain"
        Then  system will respond with success message "new user registered"