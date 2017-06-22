# DofusMapDataDecypher (DM2D)
Permet de déchiffer les mapData des cartes de jeux Dofus 1.29 

## Version
1.0.0 - Déchiffer les mapData des cartes de jeu

## Auteur
Manghao

## Utilisation
```java
Map map = new Map([int] id, [String] key, [String] mapData);
// mapData = mapData du fichier MapId_0---------X.swf
String mapData = MapDataDecypher.decypherMapData(map);
System.out.println(mapData);
```
