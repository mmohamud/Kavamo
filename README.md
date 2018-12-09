# Kavamo
[![Build Status](https://travis-ci.org/mmohamud/Kavamo.svg?branch=master)](https://travis-ci.org/mmohamud/Kavamo)


Product backlog: https://docs.google.com/spreadsheets/d/15lDRqxfrTMXDCPrglwGqPN0BPR3I7Vm245LOIWF9vEQ/edit?usp=sharing

Travis: https://travis-ci.org/mmohamud/Kavamo

Codecov: https://codecov.io/gh/mmohamud/Kavamo

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

## Jar:n luonti
jar luodaan komennolla:

    gradle shadowJar
    
