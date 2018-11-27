# Kavamo
[![Build Status](https://travis-ci.org/mmohamud/Kavamo.svg?branch=master)](https://travis-ci.org/mmohamud/Kavamo)


Product backlog: https://docs.google.com/spreadsheets/d/15lDRqxfrTMXDCPrglwGqPN0BPR3I7Vm245LOIWF9vEQ/edit?usp=sharing

Travis: https://travis-ci.org/mmohamud/Kavamo



Definition of done:
- User story toteuttaa hyväksymäkriteerit ja Cucumberissa määritellyt hyväksymätestit menevät läpi.
    - Cucumberin featuret:
        - Käyttäjä pystyy lisäämään uuden kirjalukuvinkin: https://github.com/mmohamud/Kavamo/blob/master/MyReadingTips/src/test/resources/mytips/model/newBookTip.feature
- User story läpäisee yksikkötestit (rivikattavuus vähintään 80%)
- User storyn koodi on pushattu githubiin

- Koodin ylläpidettävyys ja yhtenäinen koodityyli:
    - Nimeäminen englanniksi kuvaavilla nimillä
    - CamelCase-nimeäminen
    - CheckStyle


# Käyttöohjeita

1.
javafx-gradle-plugin -tietoja löytyi mm. täältä
https://github.com/FibreFoX/javafx-gradle-plugin/blob/newyear2018release/README.md

2.
./gradlew tasks näyttää gradle-komennot javafx:lle, erityisesti: jfxRun käynnistää ohjelman.
HUOM: käynnistyy sekä tekstin tulostaminen että graafinen käyttöliittymä.
Ohjelman voi lopettaa klikkaamalla grafiikkaikkuna oik. yläkulman ruksia.

3.
/libs -kansiossa oleva jar ei toimi.
Sen sijaan build/jfx/app -kansiossa voi kirjoittaa: java -jar project-jfx.jar

4.
Kääntäminen onnistuu Netbeansissa, ajaminen ei.
