Ausgangssituation: nur eine Zeile wird im Editor geändert.
Auswirkung: Jede Zeile wird als geändert Markiert.


Grund: 
https://git-scm.com/book/de/v1/Git-individuell-einrichten-Git-Konfiguration

-> core.autocrlf
Falls Du unter Windows programmierst oder ein anderes System benutzt und mit anderen zusammenarbeitest, 
die unter Windows programmieren, wirst Du sehr wahrscheinlich irgendwann Problemen mit Zeilenenden begegnen. 
Dies liegt daran, dass Windows sowohl ein CR Zeichen, als auch ein LF Zeichen zum Signalisieren einer neuen Zeile in Dateien verwendet. 
Mac und Linux nutzen stattdessen nur ein LF Zeichen (Mac OS bis Version 9 verwendet ein einzelnes CR Zeichen). Dies ist eine kleine, 
aber extrem störende Tatsache beim Arbeiten über Plattformgrenzen hinweg.


Lösung:
In commando-Zeile:    
`git config --global core.autocrlf false`



alle global configs anzeigen lassen:    
`git config --list`

