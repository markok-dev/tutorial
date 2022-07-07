Orientiert am Buch Clean Architecture
https://refactoring.guru/


## Clean Code

#### Was ist Clean Code
= ist leserlich und leicht verständlicher Code - was versteht man darunter:

- Code soll nicht nur funktionieren sondern für menschen verstädnlich (leserlich/logisch verständlich) sein
- man verbringt eine große menge zeit (anderen) code zu lesen
- dh. man soll ihn nicht unnötig kompliziert machen, wenn es nicht nötig ist (YAGNI)

__dazu ghören__   
- richtige Namen für Klassen, Methoden/Funktionen
- Funktionen: Anzahl der Codezeilen von Funktionen. Anzahl der Parameter
- große codeblöcke (aufsplittung in klassen/methoden)
- Keine Duplizierung von Code. Alle Stellen müssen gerade gezogen werden - man kann Stellen vergessen
- Formatierung vom Code
- Kommentare im Code 
- Vermeidung von Verschachtelungen
- Error-Handling

### Wie erreicht man Clean Code
- Rules & Concepts (Formatierungsregeln)
- gewöhnliche "best practices" folgen und "pattern" anwenden
- Design Pattern - SOLID
- Test-Driven Development

## Clean Code VS Clean Architecture
Clean Code: How to write the code

Clean Architecture: Structure your code (OSGI => Modularisierung; Monolyth; Microservices-Architecture; )


## Gesetz von Conway 
“Organizations which design systems […] are constrained to produce designs which are copies of the communication structures of these organizations.”   
„Organisationen, die Systeme entwerfen, […] sind gezwungen, Entwürfe zu erstellen, die die __Kommunikationsstrukturen__ dieser Organisationen abbilden.“   
[WIKI](https://de.wikipedia.org/wiki/Gesetz_von_Conway).

## Murphys Gesetz
alles, was schiefgehen kann, auch mit Sicherheit schiefgehen wird.

## SOLID
- SRP - Single Responsibility Principle
- OCP - Open closed
- LSP - Liskov Substitution Principle
- ISP - Interface Segregation Principle
- DIP - Dependency Inversion Principle


## Prinzipien der Komponentenkohäsion
- REP - Reuse-Release-Equivalence-Prinzip (S.121)
- CCP - Common-Closure-Prinzip
- CRP - Common-Reuse-Prinzip

## Komponentenkopplung
- ADP - Acyclic-Dependencies-Prinzip
- SDP - Stable-Dependencies-Prinzip
- SAP - Stable-Abstractions-Prinzip (S. 143)


## Weitere Schlagworte
- Inversion of Control
- Morning-After-Syndrom (S. 129)
- Conway Law (S. 167)


# SOLID
Clean Architecture S. 82   

### Single Responsibility Principle

### Open closed

### Liskov Substitution Principle

### Interface Segregation Principle

### Dependency Inversion Principle

###  Single Responsibility Principle
Seite: 86 (CleanArchitecture)   

__Aussage:__
1. "Es sollte nie mehr als einen Grund geben, eine Klasse zu modifizieren"   
2. "Ein Modul sollte nur für einen , und nur einen, User oder Stakeholder verantwortlich sein"   
__Final__
"Ein __Modul__ sollte für einen, und nur einen, __Akteur__ verantwortlich sein."   

__Akteur__: User/Stakeholder   
__Modul__: Quelldatei  

__Lösung__:  
Separierung von Code, der von verschiedenen Aktreuren genutzt wird.   
Es gibt mehrere Möglichkeiten, wobei *in allen Fällen die Funktionen in unterschiedliche Klassen verschoben werden.*   

###  Open Closed Prinzip (OCP)
__Aussage__:
"Eine Softwareentität sollte offen für Erweiterungen, aber zugleich auch geschlossen gegenüber Modifikationen sein."
Anders: "Das Verhalten einer Softwareentität sollte erweiterbar sein, ohne dass sie modifiziert werden muss.

darunter Fallen die Begriffe: Inversion of Control und Information Hiding

##### Inversion of Control
###### Merkmalse
- High-level modules should not depend on low-level modules. Both should depend on abstractions
- Abstractions should not depend on details. Details should depend on abstractions

__Da der Zweite Punkt nicht so einleuchtend ist, ist hier eine Erklärung:__   
It means that if the details change they should not affect the abstraction. The abstraction is the way clients view an object. Exactly what goes on inside the object is not important. Lets take a car for example, the pedals and steering wheel and gear lever are abstractions of what happens inside the engine. They do not depend on the details though because if someone changes my old engine for a new one I should still be able to drive the car without knowing that the engine changed.

The details on the other hand MUST conform to what the abstraction says. I would not want to implement an engine that suddenly causes the brakes to double the speed of the car. I can re-implement brakes any way I want as long as externally they behave the same way.
(Quellle: https://stackoverflow.com/questions/1710005/abstractions-should-not-depend-upon-details-details-should-depend-upon-abstract)     

Weitere Quellen:    
- Entwurfsmuster von Kopf bis Fuß - S. 138

##### Information Hiding
Information hiding is a software design principle, where certain aspects of a program or module (the “secrets”) are inaccessible to clients.   
This is done by hiding aspects of an implementation that might change behind a stable __interface__ that protects clients from the implementation details.   

##### Pattern and the "Open Closed Prinzip"
Beispiel StrategyPatterm, Decorator Pattern   
Beide Ermöglichen das Erweitern/ändern von Verhalten ohne die Implementierung zu modifizieren   



# Prinzipien der Komponentenkohäsion

### REP - Reuse-Release-Equivalence-Prinzip (S.121)
Das Reuse-Release-Equivalence-Prinzip beschreibt einen Grundsatz, der im Grundegenommen - zumindest Rückblickend - vollkommen selbstverständlich erscheint:     
Wer Softwarekomponenten wiederverwenden will, kann und wird erst  dann dazu in der Lage sein, wenn diese Komponenten im Rahmen eines Release-Tracking Prozess erfasst und mit Versionsnummern versehen wurden.

### CCP: Common-Closure-Prinzip
- ist eine Variante des Single-Responsibility-Prinzips für die Komponentenebene    
So, wie das SRP besagt, dass es nie mehr als einen Grund geben sollte, eine Klasse zu modifizieren, besagt das Common-Closure-Prinzip, dass es nie mehr als ein Grund geben sollte, eine Komponente zu modifizieren.

# Komponentenkopplung

### ADP: Acyclic-Dependencies-Prinzip
Man soll keine Zyklen zwischen den Komponenten haben

### SDP - Stable-Dependencies-Prinzip (S. 137)
Durch die Einhaltung des Stable-Dependencies-Prinzips wird sichergestellt, dass Module, die leicht anzupassen sein sollen, nicht von Modulen abhängig sind, die sich nur mit größerem AUfwand ändern lassen.

- Definition von Stabilität in der Software (S. 137)

#### Stabilitätsmetriken:
- Fan-in: Eingehende Abhängigkeiten
- Fan-out: Ausgehende Abhängigkeiten
- I:Instabilität I=Fan-out/(Fan-in+Fan.out)
Wertebereich dieser Messgröße beträgt [0, 1].    
Dabei entspricht I=0 einer maximal stabilen Komponente und I=1 einer maximal instabilen Komponente


__Stable__    
Eine Klasse x wird von 3 Klassen genutzt. Somit ist X Stabil
X ist unabhängig     
x ist verantwortlich

__Instabil__    
Eine Klasse y nutzt 3 unterliegende Klassen    
Die Klasse Y ist instabil, sie ist abhängig von den unterliegenden Klassen

Das SDP besagt,dass die Meßgröße I in Richtung der Abhängigkeit abnehmen



### SAP - Stable Abstraction Prinzip
Das SAP und SDP (Stable-Dependencies-Prinzip) ergeben zusammen das DIP (Dependency Inversion Principle) für Komponenten (S. 144)







# Was ist Softwarearchitektur
(S.153)    
Sinn und Zweck der Systemform ist es, die Entwicklung, das Deployment, den Betrieb und die Instandhaltung des darin enthaltenen Softwaresystems zu erleichtern.    

Die dahinterstehende Strategie verfolgt das Ziel, so lange wie möglich so viele Optionen wie möglich offenzuhalten.    

Der vorrangige Zweck der Softwarearchitektur besteht jedoch darin, den Lebenszyklus des Systems zu sichern. Eine gute Architektur sorgt dafür, dass das System leicht zu verstehen, einfach zu entwickel, problemlos instand zu halten und reibungslos zu deployen ist. Die ultimative Ziele sind dabei die Minimierung der Lifetime Costs (Gesamtlebenszeitkosten) und die Maximierung der Produktivität der Programmierer.

## Entwicklung

## Deployment

##


## Objektorientierte Prinzipien

### Lockere Kopplung
lockere Bindung wird bei dem Observer-Pattern verwendet.  
Das Subject weiß von seinem Beobachter nur, dass sie ein bestimmtes __Interface__ implementieren.   
Es hat demnach keine weiteren Infos von ihm.   
Sie sind also über ein Interface und nicht über eine konkrete Implementierung miteinander verbunden.   
(Quelle: DesignPattern von Kopf bis Fuß)

## KISS

## Head First - Design Pattern
__OO Basics__    
 -   Abstraction
 -   Encapsulation
 -   Polymorphism
 -   Inheritance

__OO Principles__    
- Identify the aspects of your application that vary and separate them from what stays the same [strategy pattern][Page 9]
- Program to an interface, not an implementation [Page 11]
- Favor composition over inheritance (has-a is better than is-a) / (example: strategy-pattern) [Page 23]
- Strive for loosly coupled designs between objects that interact. [Page 54]
- Classes should be open for extensions, but closed for modifications. (the O in the SOLID) [Page 86]
- Depend on abstractions. Do not depend upon concrete classes. [factory pattern][Page 139]
- Principle of Least Knowledge: talk only to your immediate friends.
- The Hollywood Principle: Don´t call us, we´ll call you. [298]
- The class should have only one reason to change. [Page 340]


## YAGNI
https://en.wikipedia.org/wiki/You_aren%27t_gonna_need_it   

https://de.wikipedia.org/wiki/YAGNI#:~:text=YAGNI%20ist%20ein%20Akronym%20und,diese%20Funktionalit%C3%A4t%20tats%C3%A4chlich%20gebraucht%20wird.





