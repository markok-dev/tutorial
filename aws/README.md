### Domain verifizieren
ℹ️ !Auf us-east-1 wechseln - dort müssen die zertifikate liegen!

Auf "AWS Certificate Manager" gehen.  
Dort auf "Request a certificate"  
"Fully qualified domain name" eingeben:  www.marko.onl 

und "DNS validation" wählen.  

bei namecheap muss man für die oben angegebene domain (www.marko.onl) ein cname-record vornehmen.   
als host war folgender Wert vorgegeben:  
`_4375e750bf2db9d3ad9f9c247e98e1e5.www.marko.onl."`   
Diesen kann man so nicht in namecheap eingeben.  
funktioniert hat folgender:  
`_4375e750bf2db9d3ad9f9c247e98e1e5.www`

analog für den domain-namen: marko.onl  
vorgegeben:  
`_d675a59c164ee00ff251b3dd7cf14991.marko.onl.`  
eingetragen:  
`_d675a59c164ee00ff251b3dd7cf14991`  

https://docs.aws.amazon.com/acm/latest/userguide/troubleshooting-DNS-validation.html


### SES - E-Mails empfangen und senden

Der Versand geht über Frankfurt   
Der Empfang geht über Irland   

Auf dem youtube-marko.k account ist ein video enthalten bezüglich der konfiguration.   

__MX Eintrag in Namecheap vornehmen__   
![image](https://user-images.githubusercontent.com/9949523/149945462-42de1b06-df92-4d2c-8929-d1d1a10672fc.png)

Der erste Eintrag gilt für alle Mails die and @marko.onl gesendet werden.   
Der zweite Eintrag gilt für alle Mails die an @info.marko.onl gesendet werden.   



# Cloudfront + static page on s3

beim erstellen von cloudfront darf kein origin aus der liste gewählt werden.
es muss auf den s3 bucket gegangen werden und dort unter "Properties" ganz unten der "Bucket website endpoint" kopieren und einfügen in cloudfront
ab minute 26:19 - https://www.youtube.com/watch?v=mls8tiiI3uc&t=1911s
