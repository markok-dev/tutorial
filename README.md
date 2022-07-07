# tutorials
repo with tutorials

# Links



# TODOS
- ITEXT - pdf bibliothek(splitten/zusammenführen etc) - https://itextpdf.com/ 
- graphviz - https://graphviz.org/ - graphen bibliothek
- https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html (password hasing + storing)
- https://github.com/trufflesecurity/trufflehog
- https://makefiletutorial.com/ (what is makefile - verwendet in AWS projekten um diese zu konfigurieren)
- https://www.smashingmagazine.com/2020/01/data-components-vue-js/#propos-share-data-parent-child 
- chrome://apps/ installierte chrome-browser apps anzeigen
- https://developer.okta.com/blog/2019/08/07/deploy-a-spring-boot-app-with-aws-elastic-beanstalk (deploy springBoot on aws)
- https://medium.com/swlh/build-deploy-a-rest-api-from-scratch-using-spring-boot-and-aws-ecs-eb369137a020 (deploy springBoot on aws with docker! TOP)
- 
- https://hookbin.com/   
- https://overthewire.org/wargames/natas/natas0.html (open friday/security)
- https://www.root-me.org/?lang=de (open friday/security)
- https://gridsome.org/ Markdown to page converter
- https://blog.mayflower.de/4392-JS-Module-Pattern.html
- https://hub.packtpub.com/the-cap-theorem-in-practice-the-consistency-vs-availability-trade-off-in-distributed-databases/
- npm vs maven - https://stackoverflow.com/questions/38388824/is-maven-similar-to-npm
- JAXB (XML zu Klassen und zurück, wurde im Maven-Kurs viel verwendet. Bsp. Kapitel 10 Video 93)
- XSD (XML Schema. Grundlagen lernen)
- OSGI vS Java Jogsaw: https://www.informatik-aktuell.de/entwicklung/programmiersprachen/java-9-das-neue-modulsystem-jigsaw-tutorial.html#:~:text=Vergleich%20zwischen%20OSGi%20und%20Jigsaw&text=OSGi%20unterst%C3%BCtzt%20Komponenten%2DVersionierung.,also%20nicht%20starten%20oder%20stoppen.
- REST VS SOAP https://www.redhat.com/de/topics/integration/whats-the-difference-between-soap-rest#:~:text=SOAP%20(Simple%20Object%20Access%20Protocol,Entwicklers%20entweder%20REST%20oder%20SOAP.
- https://www.informatik-aktuell.de/entwicklung/programmiersprachen/reactive-programming-mehr-als-nur-streams-und-lambdas.html
- https://www.linux-magazin.de/ausgaben/2004/05/smart-ausweisen/2/
- https://de.wikipedia.org/wiki/Challenge-Response-Authentifizierung
- https://www.cloudflare.com/de-de/learning/ssl/what-happens-in-a-tls-handshake/?utm_referrer=https://www.google.com/
- idempotent (meaning)
- Time-Based One-Time Password (TOTP)
- https://de.wikipedia.org/wiki/Lorem_ipsum    
- https://www.baeldung.com/java-classloaders   
- https://de.wikipedia.org/wiki/YAML     
- https://docs.oracle.com/javase/tutorial/essential/io/streams.html     
- https://www.geeksforgeeks.org/skip-list/      
- SOLID    
- FactoryPattern   
- Docker
- SSH Crash Course | With Some DevOps - https://www.youtube.com/watch?v=hQWRp-FdTpc   
- googles tote Produkte https://gcemetery.co/

# News und infos

Imperative Programmierung

## JavaScript 

# Einführung in die asynchrone JavaScript-Programmierung
https://m.heise.de/developer/artikel/Einfuehrung-in-die-asynchrone-JavaScript-Programmierung-2752531.html?seite=all

# password strength check
https://www.webdesignerdepot.com/2012/01/password-strength-verification-with-jquery/

##  Java    

## specification vs implementation
JAX-RS is a specification - and jersey an implementation:    
https://www.baeldung.com/jax-rs-spec-and-implementations    

Tutorials:    
- https://mkyong.com/    
- String accessToken = Optional.ofNullable(authResult).map(e -> e.accessToken).orElse(null);   

News
- https://jaxenter.de/     

- java infos, tutorials    
https://www.baeldung.com/     


## non blocking io
Blocking vs Non-blocking Languages: https://www.youtube.com/watch?v=aVLjh8A6OGU     

https://www.youtube.com/watch?v=jOupHNvDIq8

- javascript in node.js is non-blocking. code wird im hintergrund ausgeführt und geht im code weiter. mit callbacks reagiert man darauf    
https://blog.codecentric.de/en/2019/04/explain-non-blocking-i-o-like-im-five/

https://medium.com/@mr.anmolsehgal/non-blocking-io-java-nio-b18e53a92bad

https://stackoverflow.com/questions/34855352/how-in-general-does-node-js-handle-10-000-concurrent-requests/34857298

Think Async in Java 8 by Dmitry Aleksandrov    
https://www.youtube.com/watch?v=1QW2m0q_bN4

## Testdaten
https://de.wikipedia.org/wiki/Lorem_ipsum    

## Encoding
https://www.joelonsoftware.com/2003/10/08/the-absolute-minimum-every-software-developer-absolutely-positively-must-know-about-unicode-and-character-sets-no-excuses/

## Grundlagen Objektorientierung

- SOLID - Prinzip    
https://howtodoinjava.com/best-practices/5-class-design-principles-solid-in-java/    

# SOAP vs REST
https://www.oio.de/public/xml/rest-webservices.pdf    
### REST = REpresentational State Transfer

- REST ist kein Produkt oder Standard. Es beschreibt, wie Web Standards in einer Web gerechten Weise eingesetzt werden können.    
- Es gibt Resourcen, die Adressiert werden können 
- rest ist stateless
  each request from client to server must contain all of the information necessary to understand the request, and cannot take advantage of any stored context on the server. Session state is therefore kept entirely on the client

- HTTP Methoden:
 - GET: holt eine Resource
 - POST: etwas hinuzfügen (Ware in ein Warenkorb)
 - PUT: anlegen einer neuen Resource
 - DELETE: löschen einer Resource
 
 ### SOAP
 SOAP ist ein Protokoll    
 
### What is the CAP Theorem?
The CAP Theorem, developed by computer scientist Eric Brewer in the late nineties, states that databases can only ever fulfil two out of three elements:    
- Consistency – that reads are always up to date, which means any client making a request to the database will get the same view of data.    
- Availability – database requests always receive a response (when valid).
- Partition tolerance – that a network fault doesn’t prevent messaging between nodes.
 Quelle: https://hub.packtpub.com/the-cap-theorem-in-practice-the-consistency-vs-availability-trade-off-in-distributed-databases/    
 https://de.wikipedia.org/wiki/CAP-Theorem

## Technologien

- Webservices    
https://www.crisp-research.com/microservice-cloud-und-iot-applikationen-zwingen-den-cio-zu-neuartigen-architekturkonzepten/




# OpenShift
OpenShift liegt über Kubernetes.    
Unter Kubernetes sind die Container.

- https://containerjournal.com/topics/container-ecosystems/openshift-kubernetes-and-docker-a-quick-comparison/    
- https://jaxenter.de/openshift-docker-und-kubernetes-77409
