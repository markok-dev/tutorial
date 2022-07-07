# Time

Timestamp (milliseconds): 1583507596483   
Date parsed (dd.MM.yyyy HH:mm:ss): 06.03.2020 16:13:16   


1 Sekunde = 1000 Millisekunden   

24 (Stunden) * 60 (Minuten) * 60 (Sekunden) * 1000(Millisekunden) = Millisekunden am Tag   

# what is a timestamp

### starts at the Unix Epoch on January 1st, 1970 at UTC.
Are milliseconds from 01.01.1970 in der Zeitzone UTC.

https://de.wikipedia.org/wiki/Koordinierte_Weltzeit#/media/Datei:Standard_Time_Zones_of_the_World_(October_2015).svg    

UTC ist der Nullpunkt.
Germany is UTC+1 in der Sommerzeit jedoch UTC+2.


__beispiel__

Millisekunden: 1655886519645   
Deutsches Datum: 22.06.2022 10:28:39   
UTC Datum: 22.06.2022 08:28:39  

Wie wir sehen, ist das UTC-Datum 2 Stunden zurück. Deutschland ist generell UTC+1 in diesem Fall aufgrund der Sommerzeit +2.   
Speichert man also seine Deutsche Zeit in UTC, ist wird diese also "genormt".

Hat man ein Timestamp vorliegen und man möchte ein Datum daraus parsen, muss man auch immer eine Zeitzone angeben.   
Weil der Zeitpunkt war in New York ein anderer als in Deutschland - eben aufgrund der Zeitzonen.
