## SonarCloud

Létrehoztam egyúj organizációt SonarCloud-on. Hozzáadtam a projektet az organizációhoz a következő módon:
- Secret beállítása
- build.yml létrehozása
  - Megfelelő branch beállítása
- pom.xml bővítése az url és organizáció property-vel
- Jelzett hibák kijavítása


![sonarCloud1.png](sonarCloud1.png)

![sonarCloud2.png](sonarCloud2.png)

További javítgatások után, a végső minőség:

![sonarCloudBetter.png](sonarCloudBetter.png)

- a megmaradt code smell-eket nem találtuk túl fontosnak, és a legtöbb felesleges javítás lett volna, így azokat békén hagytuk

Résztvevők: Veress Dániel, Tóth András