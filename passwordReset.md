# LInks
https://www.troyhunt.com/everything-you-ever-wanted-to-know/

# Password Set and reset

Es wird eine DB-Tabelle (User bsp: FolderUser) angelegt.   
Diese Tabelle hat ein sogenannten resetCode und eine E-Mail Adresse von einem Benutzer.   
Der resetCode ist ein eindeutiger String einer bestimmten länge (Bsp: 32 Zeichen).

Zudem hält die Tabelle noch eine "collectionId". Um diese collection geht es in diesem Fall. Das Password dieser collection soll gesetzt bzw geändert werden.


## Password initial setzen -> Benutzer klickt auf die mail
http://localhost:4000/apps/payroll/index.html?*code*=G59Ti6JyLdOuSh6S2fs2Xb8u4A87aU&*state*=geydambqgays6ojpovzwk4s7gfstsmztgnrdqljtmfrdqljug44tcllbheydcljug43tgmzthe4tcyrsgqxtsoi&*lop*=oha256m9w


Klickt der Benutzer auf die Mail, wird eine Page mit dem Link aufgerufen. Die Parameter werden mitgeschickt. 
Auf der Page hat der Benutzer die Möglichkeit, sein Password für seine collection zu setzen.

Beim klicken auf "Speichern" wird dem Webservice die beiden oben genannten Parameter sowie nun auch noch das password zugeschickt.

Der Server ordnet den Benutzer einer Instanz und Organisation zu.   
Der Server findet mit dem resetCode den richtigen FolderUser.   
Der Server setzt für den Benutzer das password für die collectionId (die aus der FolderUser-Tabelle gewonnen wurde.)
Der Server schickt am Ende eine Mail zur Collection. Mit dem vergebenen Password kann der Benutzer sich dann einloggen.
In dieser Mail ist auch ein Link für den Passowrd-reset enthalten.
Der resetcode von der Tabelle "FolderUser" wird auf null gesetzt.

Die Werte(resetCode) in der URL in der initialen Mail werden beim klick auf speichen an das entsprechende Webservice geschickt. Die Aufgerufene Seite machte nichts mit den Werten. Der ResetCode wurde von der Seite nicht ausgewertet. Der resetCode wurde einfach weitergeschleift nach dem klick auf Speichern. Der Webservice brauch ihn, um den Benutzer zuzuordnen. Die aufgerufene Seite hat lediglich das Password hinzugefügt.


## Password zurücksetzen anfordern -> Mail wird verschickt

Möchte dieser Benutzer nun sein Password setzen, bekommt er eine Mail mit einem Link.
Diese E-Mail wird ihm zugeschickt, wenn er das erste Mal was in der Sammlung abholen kann.   

In dem Link sind mehrere Parameter enthalten:

- code:   
Ein Parameter identifiziert den Benutzer (seine Organisation und Instanz). Damit kann der Server den Benutzer dann zuordnen

- resetCode:   
Mit diesem Code sucht man den FolderUser in der Organisation und Instanz, die bereits ermittelt wurden. Über den resetCode haben wir Zugriff auf die collectionId und wissen nun für welche collection wir das Passowrd resetten müssen.

## Password-Reset

In der Mail ist auch ein link zum Password-reset.   
Enthält der Link Parameter? 
Der Link enthält nur den code, um in die richtige Instanz und Organisation zu kommen.    
Auf der Page hat der Benutzer die Möglichkeit seine E-Mail Adresse einzugeben.

Diese E-Mail Adresse und der code wird zum Server geschickt.

Der Server prüft ob es einen FolderUser mit dieser E-Mail gibt.
Wenn ja:
Der Server erzeugt für den folderUser ein resetCode.
Reminder: Der resetCode wurde bei der initialen Password-vergabe gelöscht.

Der Server verschickt einen Link mit dem oben genannten code (Organisation/Instanz ermittlung) und den resetCode an den Benutzer.
Klickt er auf den Code, wird in dem Sinne die Page der initalen Passwordvergabe aufgerufen und das spiel geht von vorne los.
Mit dem unterschied, dass jetzt das passord nicht initial, sondern neu gesetzt wird


