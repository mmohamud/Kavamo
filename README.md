# Kavamo
[![Build Status](https://travis-ci.org/mmohamud/Kavamo.svg?branch=master)](https://travis-ci.org/mmohamud/Kavamo)

[Loppuraportti](https://docs.google.com/document/d/1wx20kjL9jjrroIxMNa-xpjeYLPAsa_XrzJ8niEEnm_0/edit?usp=sharing)

[Product backlog ja sprint backlogit](https://docs.google.com/spreadsheets/d/15lDRqxfrTMXDCPrglwGqPN0BPR3I7Vm245LOIWF9vEQ/edit?usp=sharing)

[Travis CI](https://travis-ci.org/mmohamud/Kavamo)

[Codecov testikattavuus](https://codecov.io/gh/mmohamud/Kavamo)

Definition of done:
- User story toteuttaa hyväksymäkriteerit ja Cucumberissa määritellyt hyväksymätestit menevät läpi.
    - Cucumberin featuret:
        - Saatavilla backlogissa
- User story läpäisee yksikkötestit (rivikattavuus vähintään 80%)
- User storyn koodi on pushattu githubiin

- Koodin ylläpidettävyys ja yhtenäinen koodityyli:
    - Nimeäminen englanniksi kuvaavilla nimillä
    - CamelCase-nimeäminen
    - CheckStyle

## Jar:n luonti
jar luodaan komennolla:

    gradle shadowJar

## Jar:n luonti ja ajo skriptillä

    ./jartip
