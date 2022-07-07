# SVG

wird benutzt um charts in html anzuzeigen.   

### Spezifikation
als einstieg Punkt 9 - Basic Shapes (Wie z.B. rect)
https://www.w3.org/TR/SVG11/   

### Example

#### rect
```
  <svg xmlns="http://www.w3.org/2000/svg" width="500" height="500">
    <rect x="0" y="10" width="10" height="100" style="fill:red"/>
    <rect x="30" y="0" width="10" height="100" style="fill:blue"/>
  </svg>
```
Dieses kann in eine HTML-Datei in den body-Tag hinterlegt werden.   
Oder so in eine Datei mit der Endung `.svg` und geöffnet werden.   


#### polyline
```
<svg xmlns="http://www.w3.org/2000/svg" width="500" height="500">
  <polyline fill="none" stroke="blue" stroke-width="20" 
   points="0,40 40,40 40,80 80,80 80,120" />
 </svg>
```
Hier kann man Koordinaten-Punkte definieren die dann miteinander verbunden werden.   
Oben links ist x=0 und y=0    
Mit steigendem y geht man den Bildschirm von oben nach unten.    
Ein Pärchen entspricht zwei Punkte die verbunden werden - also einer Linie: 0,40 40,40
