# Ausgangsrechnung
Ich schreibe meinem Kunden (Debitor) eine Rechnung, die er zu zahlen hat.  

Vorher einen Debitor erstellen, den man dann im Soll auswählt.

__Reminder__
# Soll / Haben

- Aktiv-Konten mehren sich im Soll  
- Passiv-Konten mehren sich im Haben  

- Kreditoren-konten mehren sich im Haben
- Kreditoren-konten mindern sich im Soll

- Debitoren-konten mehren sich im Soll
- Debitoren-konten mindern sihc im Haben


__Buchen__   
Soll: 10001 (Debitor)  
Haben: 8400 (Erlöse 19 % / 16 % USt)  
Betrag: 100,00€

Im Journal zu sehen:  
![image](https://user-images.githubusercontent.com/9949523/133806097-de773039-8d4a-439f-8fa0-60a2696960f3.png)

im Journal sieht man zwei Konten, die in der Buchung nicht explizit angegeben hat:

[Sachkonto] __1400__ - Aktivkonto - "Forderungen aus Lieferung und Leistungen"  im Soll gebucht  
ℹ️ Aktiv-Konto: "Wie das Vermögen des Unternehmens finanziert wurde" -> in diesem Fall aus "Forderungen"  
ℹ️ Aktiv-Konten mehren sich im Soll (Passiv-Konten somit im Haben)
Dieses wurde erstellt, weil man einen Debitor gebucht hat.   
Es gibt einen Eintrag im Sachkonto und im Personenkonto, der auch tatsächlich bebucht wurde.  


[Sachkonto] __1776__ - Passivkonto - "Umsatzsteuer 19%"  
Dieses wurde erzeugt, weil wir 8400 bebucht haben. Hier wird die Umsatzsteuer verbucht.

[Erlöskonto] __8400__ - "Erlöse 19 % / 16 % USt"  
Wir haben Umsatz durch den Verkauf gemacht, deswegen wird dies auf ein Erlös konto gebucht.

__OFFENE POSTEN__  
Dadurch entsteht auch ein Eintrag in den Offenen Posten:  
![image](https://user-images.githubusercontent.com/9949523/133816281-6e0c1fd7-7cfe-4202-b0cf-7861aec1bd98.png)

Hier sieht man, dass der Kunde diesen Betrag noch Zahlen muss.

Dies passiert mit der nächsten Buchung:   

# Eingangszahlung
ich habe die Zahlung vom Kunden erhalten und nun verbuche ich diese:  

Soll: 1200 (Bank)  
Haben: 10001 (Debitor)  
Betrag: 100,00€  

![image](https://user-images.githubusercontent.com/9949523/133817853-ed24ee32-99c5-4b36-8bed-e77e16671ec3.png)

1400 - Aktivkonto - "Forderungen aus Lieferungen und Leistungen" im Haben bebucht   
ℹ️ Aktiv-Konten mehren sich im Soll (Passiv-Konten somit im Haben)


die Offenen Posten sehen jetzt so aus:
![image](https://user-images.githubusercontent.com/9949523/133818337-04393f02-cf9d-4162-a333-5a5bf839258e.png)





 
