# Java Script Date

### Tags
javaScript, date, time, timezone, formatting, date-formatting,

### Libraries (externe Bibliotheken)
Eine sehr beliebte lib war moment.js. Diese ist aber out-dated.   
Da hilft ein blick auf die Seite vom Projektstatus:   
- https://momentjs.com/docs/#/-project-status/    
Eine Seite mit alternativen ist hier zu finden (wird auch in der Projekt-Status Seite verlinkt)    
https://github.com/you-dont-need/You-Dont-Need-Momentjs/blob/master/README.md      


# The Date-Object
ℹ️ GMT und UTC sind gleich    
ℹ️ Angabe vom Monat - 1 beim Date-Konstruktor. 0 = Januar / 6 = Juli   

Das Date-Object speichert Werte im UTC format. Er nimmt beim Speichern eine Umwandlung/Normung in das UTC-Format vor.   
Er erkennt die Timezone von System und wandelt diese dann beim Speichern in das UTC-Format.
Man muss also bei der __Ausgabe__ die Zeit in einer bestimmten __Zeitzone__ ausgeben um die korrekte Zeit angezeigt zu bekommen.   
Zudem muss noch angegeben werden, in welchem __Format__ das Datum ausgegeben werden soll.   
Mögliche Formate `DD.MM.YYYY `, `MM.DD.YYYY`    

Entscheident sind demnach __Zeitzone__ und __Format__.

### UTC und Unix Timestamp
Gleich ist es mit einem Unix-Timestamp.   
Der Timestamp ist ein Moment den man festgehalten hat.   
Dieser moment war Zeitlich gesehen in Deutschland ein anderer als in NewYork oder Japan.     
Möchte man nun diesen Timestamp ausgeben lassen, muss man angeben, in welcher Zeitzone man diesen Moment ausgeben lassen möchte.   

UTC ist also auch eine Normierung. Alle Zeiten werden beim Date-Objekt als UTC gespeichert/abgelegt.  
Es speichert demnach auch einen Moment.   
Möchte man diesen Momant in der Zeitzone Berlin/Sommerzeit umrechnen, so muss man UTC + 2 Stunden rechnen.


### d.setFullYear
Ausführungszeitpunkt: 26.06.22 / 19:30 Uhr


```
let d = new Date();
d.setFullYear(2022, 5, 21); 
```

Er speichert ein gegebenes Datum mit der Aktuellen Uhrzeit ab.   
Beim Speichern wird in das UTC Format umgewandelt / genormt.  
Das Programm wurde um 19:30 Sommerzeit (UTC+2) ausgeführt. Deswegen bekommt man als Ausgabe UTC 17:30 (19:30 - 2 Stunden)

__Ausgabe__
```
console.log(d);
2022-06-21T17:30:18.103Z
```
Es wurde also das Datum ausgegeben das setFullYear übergeben wurde. Zusätzlich wurde noch die Uhrzeit zum Zeitpunkt der Ausführung hinzugefügt und als UTC gespeichert.

__Ausgabe d.toTimeString()__   
Hier wird das gespeicherte UTC Datum in der aktuellen Zeitzone (GMT/UTC+2) ausgegeben

```
console.log(d.toTimeString())
19:30:18 GMT+0200 (GMT+02:00)
```


### new Date(2019, 5, 11);
Ausführungszeitpunkt: 26.06.22 / 19:30 Uhr

```
let y = new Date(2019, 5, 11);
```

__Ausgabe__   
Er speichert ein gegebenes Datum OHNE aktuelle Uhrzeit ab.   
Beim Speichern wird in das UTC Format umgewandelt / genormt.  
Das Programm speichert den angegebenen Tag 11.06.2019 mit der Uhrzeit 0 Uhr in UTC ab.  
Der 11.06.2019 um 0 Uhr in UTC ist -2 (-2 wegen der Sommerzeit)   
und das entspricht den: 10.06.2019 um 22 Uhr!   

```
console.log(y);
2019-06-10T22:00:00.000Z
```

__Ausgabe d.toTimeString()__   
Hier wird das gespeicherte UTC Datum in der aktuellen Zeitzone (GMT/UTC+2) ausgegeben.
Es wird genau 0 Uhr sein, da die 2 Stunden erneut draufgerechnet werden.

```
console.log(d.toTimeString())
00:00:00 GMT+0200 (GMT+02:00)
```

# d.setFullYear VS new Date(2019, 5, 11)

Beide verhalten sich gleich.    
`d.setFullYear` nimmt noch die aktuelle Uhrzeit/die Uhrzeit zum Zeitpunkt der Ausführung hinzu.  

__Überlegungen__    
Ich habe dem System ein Datum übergeben den er dann nach UTC umwandelte.   
Um dies jedoch zu tun, muss er ja auch wissen, wie er diese Umwandlung vornimmt.   
Das System benötigt demnach Kentnisse über meine Zeitzone um dann die entsprechende Berechnung durchzuführen.    
Die in meinem Fall da wäre "Zeit - 2" da ich mich in der Zeitzone Berlin/Sommerzeit +2 Stunden befinde.

__Verhalten in unterschiedlichen Zeitzonen__    
Mein System schickt den 11.06.1996 jeweils zu jemanden nach Berlin / New York / Japan. Was wird passieren?    

Das Datum wird vom jeweiligen System entgegen genommen und es wird ein Date-Object erzeugt.    
Dabei wird die aktuelle Zeitzone berücksichtigt und nach UTC gewandelt.    
Es bleibt also bei jedem der 11.06.1996.   

Kommt das Datum ursprünglich aus dem deutschen Raum und man zeigt es in Japan ebenfalls als den 11.06.1996 an, kann es ggf falsch sein.    
Damit es der Japaner aber richtig anzeigen kann muss er entweder wissen, dass es als UTC+2 (Berlin, Sommerzeit) gespeichert ist oder eben als UTC - dann kann das japanische System die entsprechenden Konvertierungen vornehmen.   

Es geht beim Date-Object um die Speicherung des Zeitpunktes.    
Nun gilt es das Datum richtig auszugeben unter berücksichtigung von Zeitzone und Format.   

# Zeitangabe in UTC
möchte man die Zeit direkt in UTC angeben macht man das so:
```
let x = new Date(Date.UTC(2019, 5, 11));
```
damit nimmt er die Zeit direkt als UTC-Zeit. Er guckt also nicht auf die Systemzeit der Maschiene um eine Umrechnung nach UTC zu machen.    
Er speichert as it is als UTC.   


# Formatierung von Date
Das Date-Objekt speichert also ein Datum, dass nach UTC/GMC genormt wurde.   
Gibt man es sich aus, kann dies verwirrend sein - es passt nicht zum aktuellen Datum. Da eben eine Umwandlung durchgeführt wurde.   
Das Date-Objekt ist demnach eine Art Timestamp - ein Zeitpunkt.     
Diesen kann man sich nun Ausgeben und jeweils die __Timezone__ und das __Format__ definieren.  
Das Date Objekt an sich dient nicht wirklich zur Ausgabe. Man muss die Ausgabe mit anderen Klassen vornehmen.   

## Formatierungscode

https://devhints.io/wip/intl-datetime   

Mit diesem Code kann man ein Date-Objekt ausgeben.    
Dabei kann man die Zeitzone (im options-Objekt) und auch das Format (im DateTimeFormat als Parameter) angeben.    

```
function formatDateObject(date, locale = 'de') {
  const options = {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',

    //timeZone: UTC //'America/New_York', //UTC
  };

  let loc = null;
  if (locale === 'de') {
    loc = 'de-DE';
  } else {
    loc = 'en-US'; //en-ca, en-US
  }
  console.log('ppp log set: ' + loc);
  return new Intl.DateTimeFormat(loc, options).format(date);
}
```

#### Beispiel
Aufruf der Funktion mit Timezone "America/New_York en-US"

Code:    
```
let y = new Date(2019, 5, 11);
console.log(y);

const x = formatDateObject(y, 'en');
console.log(x);
```

Ausgabe:   
```
2019-06-10T22:00:00.000Z
06/10/2019, 6:00:00 PM
```
erste Zeile ist UTC normiert. 
nach new york usa ist die Zeit UTC - 4 stunden in der sommerzeit.
(22 Uhr - 4) = (18 Uhr) = (6 PM )






# Ausgaben des Programms

```
function formatDateObject(date, locale = 'de') {
  const options = {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',

    //timeZone: UTC//'America/New_York', //UTC
  };

  let loc = null;
  if (locale === 'de') {
    loc = 'de-DE';
  } else {
    loc = 'en-US'; //en-ca, en-US
  }
  console.log('ppp log set: ' + loc);
  return new Intl.DateTimeFormat(loc, options).format(date);
}

console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');

let d = new Date();

d.setFullYear(2022, 5, 21); // dies wird als UTC-Zeit gespeichert es wird die aktuelle uhrzeit gespeichert und nach utc gewandelt (-2 stunden bei berlin in der sommerzeit)
console.log('erstellt mit: d.setFullYear(2022, 5, 21);');
console.log(d);
console.log(d.toUTCString());
console.log(d.toDateString());
console.log(d.toJSON());
console.log(d.toTimeString()); // (*44) hier sieht man die zeit in der aktuellen GMT-Berlin zeit
console.log('## formatting:');
console.log(formatDateObject(d, 'de'));
console.log(formatDateObject(d, 'en'));

console.log('---------------------------------------');

let y = new Date(2019, 5, 11); // hier wird die aktuelle zeitzone nach utc berechnet
console.log('erstellt mit: new Date(2019, 5, 11);');
console.log(y);
console.log(y.toUTCString());
console.log(y.toDateString());
console.log(y.toJSON());
console.log(y.toTimeString());
console.log('## formatting:');
console.log(formatDateObject(y, 'de'));
console.log(formatDateObject(y, 'en'));

console.log('---------------------------------------');
console.log('erstellt mit: new Date(Date.UTC(2019, 5, 11);');
let x = new Date(Date.UTC(2019, 5, 11));
console.log(x);
console.log(x.toUTCString());
console.log(x.toDateString());
console.log(x.toJSON());
console.log(x.toTimeString());
console.log('## formatting:');
console.log(formatDateObject(x, 'de'));
console.log(formatDateObject(x, 'en'));

console.log('<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<');
```
