# Udemy Kurs - Spring und Hibernate für Anfänger (mit Spring Boot 2)

Die Informationen Stammen vom Udemy-Kurs


Wir haben einen Service und einen Controller angelegt.

# Service vs Controller
Services sind dafür da den BusinessCode zu kapseln.   
Controler benutzt man um Requests an die Services weiterzuleiten.   
= Controller benutzen die funktionalität der Services.

### service
Geht man in die Klasse/inter rein `org.springframework.stereotype.Service`, 
sieht man, dass Service ein alias von Component ist.   
Service ist also auch ein Component.   

Technisch ist es ein Component, es soll aber einen "Service" ausdrücken.   
Dient also nur der Information.   

# @Component
unterschied zu @Service? -> siehe erklärung oben! (kurz: Service ein alias von Component)


# @ComponentScan(basePackages = {"de.oette.course.B07"}) 
//Video Abschnitt 2 - Video 22
Scannt alle Klassen in diesem (und in den Unterordnern) welche Anontationen an den Klassen stehen und packt sie in den context.   
Er packt die mit der @Component anontierten Klassen in den Context. - beachte: auch @Service ist eine Componente
Dies stand an der "Start-Klasse" dran. Man hat hier immer dann das package angepasst: "de.oette.course.B07"   
Jedes Video hatte sein package.   

Parallel dazu gibt es den @EntityScan(basePackages = {"de.oette.course.C02"})   
für die Entitäten der Persistence Engine.

# @Configuration

-> Abschnitt 6 -> Konfiguration
sobald man @Component schreibt, spring scannt diese klasse und erzeugt eine Component

# @Scope("singleton")
-> behandelt im Video "SingletonScope und RequestScope"   
wird impliziet hinzugefügt, wenn man @Service nutzt   



#application-context
Komponente von Spring bei der ich Klassen registireren und Objekte erzeugen kann

# persistence-context
Klassen registireren und Objekte verwalten.   
von der idee her ähnlich dem applicationscontext.  eine zentrale klasse, die die objekte verwaltet. 
wo man die entitäten abrufen kann. 

# ModelAndView
Wozu wird das Keyword @Autowired verwendet?   

# Fragen im Kurs
### Von Spring verwaltete Klassen (z.b. mit @Service Annotation)    
werden automatisch instanziiert und zu annotierten Variablen zugewiesen.





### Was ist der Unterschied zwischen @Controller und @RestController
@Controller verwendet man für die Präsentation von Webinhalten / MVC (Model View Controller)   

@RestController verwendet man für technische Schnittstellen 

-> Video 37. RestControler (Lesezeichen)
Ist technisch die kombination: @Controller und @ResponseBody   


# Dependency-Injection: @Autowired VS @Inject

Autowired liegt im package:   
`import org.springframework.beans.factory.annotation.Autowired;`   
liegt im SpringFramework.   

Inject liegt im package:   
`import javax.inject.Inject;`   
Wurde in die Java-Standard übernommen. Kann dann übergreifend benutzt werden.   

Beide können parallel benutzt werden.
# Bean
Bean steht für alle Klasse, die von dem Framework verwaltet werden.   

# @EventListener(ApplicationReadyEvent.class)


# @ResponseBody
TODO


# @GetMapping(value = {"/{text}", "/hello/{text}", "/{text}/hello"}) 
Das ist eine kurzschreibweise für @RequestMapping(value = "/hello-world", method = RequestMethod.GET)

# @RequestMapping(value = "/hello-world", method = RequestMethod.GET
//TODO
auch die unterscheidung, wenn es an eine Methode steht oder an der Klasse.   
Siehe DispatcherDemoController.java   

# @Transactional 
Steht über einer Methode.   
Startet eine transaction beim Betreten der Methode und am Ende der Methode schließt er die Transaction.    










