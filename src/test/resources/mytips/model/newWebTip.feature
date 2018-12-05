Feature: User can create a new web reading tip

  Scenario: adding a webtip is successfull with valid inputs
    Given  commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja Video tai blogipostaus are selected	
    When valid url "https://www.youtube.com/watch?v=HXV3zeQKqGY", author "freeCodeCamp.org", title "SQL - Full course for beginners", summary "Sql tutorial", comment "Great tutorial for beginners"  and type "video" are given
    And command lopeta is selected
    Then the webtip is saved and the system prints "Lukuvinkki tallennettu!"
