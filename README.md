## Algoritmusok és adatszerkezetek gyakorlat beadandó feladat

### Nébl Annamária, Neptun: K04POD

### Keresés, rendezés, mohó stratégia

Link a feladathoz:
[Apartments](https://cses.fi/problemset/task/1084)

CSES tesztfileok a projektbe csatolva unit tesztekként

## Feladat:
* A feladatban n jelentkező és m szabad apartman van.
* Minden jelentkezőnek van egy kívánt apartman mérete, és elfogadja azokat az apartmanokat, amelyek a kívánt mérettől legfeljebb k eltéréssel bírnak.
* Cél: a lehető legtöbb jelentkezőnek apartmant biztosítani.
* Visszatérési érték: a kapott apartmanok száma.

## Input:
* Az első sor három egész számot tartalmaz: n (a jelentkezők száma), m (a szabad apartmanok száma) és k (a maximális megengedett eltérés).
* A második sor n egész számot tartalmaz, amely a jelentkezők kívánt apartman méreteit tartalmazza.
* A harmadik sor m egész számot tartalmaz, amely az apartmanok méreteit tartalmazza.
## Algoritmus:
* Mohó algoritmus
## Kivitelezés:
1. Először eltárolom a jelentkezők és az apartmanok számát változókban
2. Ezután egy for ciklus segítségével eltárolom a kívánt apartman méreteket egy tömbben
3. Hasonló módon eltárolom az apartmanok méreteit egy másik tömbben
4. Mindkét tömböt sorba rendezem.
5. Két pointert (i és j) használok, amelyek az jelentkezők és az apartmanok listáját indexelik:
    - Ellenőrzöm, hogy az apartman mérete beleesik-e a jelentkező kívánt méreteinek megfelelő tartományba k maximális eltéréssel
    - Ha igen, akkor hozzárendelem az apartmant a jelentkezőhöz és mindkét mutatót előre léptetem
    - Ha az apartman mérete kisebb a szükséges tartománynál, akkor csak az apartman mutatót léptetem előre
    - Ha az apartman mérete nagyobb, akkor a jelentkező mutatót léptetem előre
6. Ezt a folyamatot addig folytatom, amíg a jelentkezők vagy az apartmanok listájának végére nem érek
7. Végül visszaadom a sikeresen elhelyezett jelentkezők számát
