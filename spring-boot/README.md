
## Initializer

https://start.spring.io/


## @Service
Services sind üblicherweise dafür da, die Logik / den Business-Code zu kapseln.  
Ein Alias ist eine Component  

## @Controller
Controller benutzt man um Reqests weiterzuleiten an den Service  
Ist auch ein Component  

## @Component 
__@Service__ und __@Conroller__ sind Componenten (strg + klick auf Annontation)  
Die heißen anders, um auch eine fachliche Unterscheidung - technisch ist es das gleiche   
Was sie gleich haben ist, dass sie mit der Annontation automatisch vom Framework erzeugt werden.  


## @ Autowired vs @ Inject
https://www.udemy.com/course/spring-beginner/learn/lecture/14666138#overview  

@Autowired  
Ist Spring spezifisch

@Inject  
Ist Java-Standard  


## Bean im ApplicationContext
https://www.udemy.com/course/spring-beginner/learn/lecture/14666142#overview  
Eine Bean ist eine Klasse, die vom ApplicationContxt verwaltet wird  




# REST


### Abfangen von Parametern
__RequestParam vs PathVariable__  

```
@GetMapping("/depotentry")
public DepotEntry getQuestions(@RequestParam String id, @RequestParam(required = false) String name)
```
http://localhost:8080/api/v1/depotentry?id=15  

```
@GetMapping("/pathVarTest/{text}")
public String getTest(@PathVariable(required = false, value = "text") String valueP) {
    return "~~~~" + valueP;
}
```
###
http://localhost:8080/api/v1/pathVarTest/thisIsAParameter  

-> zudem möglich "/{text}", "/{text}/hello"


