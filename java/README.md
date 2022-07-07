# Links
https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java



## Designpattern
https://sourcemaking.com/design_patterns


# Bit-Manipulation
verschieben nach links - multiplikation mit Zweier-Potenz:   
```java
int d = 10;
System.out.println(d<<3);
```

Ergebnis: 80    
10 * 2^3 = 10 * 8 = 80 
 

# Optional - Nullable

https://blog.viadee.de/java-optionals-best-practices
```java
String accessToken = Optional.ofNullable(authResult).map(e -> e.accessToken).orElse(null);

Optional<PostgresDemoEntity> entityOptional = Optional.ofNullable(entityManager.find(PostgresDemoEntity.class, 1L));   
if (entityOptional.isPresent()) {   
	PostgresDemoEntity entity = entityOptional.get();   
}  
```
   
Die Empfehlung der Expert Group (EG) des JSR 335 (Java Specification Request zu Lambda Ausdrücken) lautet, Optionals nur als Return-Type zu nutzen. In der EG-Mailing-List wurde sogar vorgeschlagen, Optional in OptionalReturn umzubenennen


## Hashcode / equals 

* Zur Erinnerung: die Default-Implementierung von equals() in der Klasse Object vergleicht die Adressen der beiden Objekte.  Die oben spezifizierte Implementierung von hashCode() ist dazu konsistent: es geht in beide Methoden lediglich die Adresse des Objekts ein. 

* Es ist egal, wie oft man hashCode() aufruft; es kommt immer der gleiche Wert heraus, es sei denn, der Inhalt des Objekts hat sich geändert. Das gilt aber nur für einen Programmlauf; beim nächsten Ablauf des Programms darf hashCode() einen anderen Wert produzieren.
* Wenn zwei Objekte gleich sind, dann müssen sie den gleichen Hash-Code haben.
* Wenn zwei Objekte verschieden sind, dann müssen sie deshalb keine unterschiedlichen Hash-Codes haben.  Es wäre aber besser für die Performance, wenn die Hash-Codes von ungleichen Objekten verschieden wären.    

Hier sieht man deutlich die enge Beziehung zwischen equals() und hashCode():
    
* Die "Gleichheit zweier Objekte" im hashCode-Contract ist die Gleichheit, die durch equals() definiert ist. Das heißt, aus x.equals(y) muss sich (x.hashCode() == y.hashCode()) ergeben.
* Mit "Inhalt des Objekts" ist im hashCode -Contract der Inhalt des Objekts gemeint, der für den Vergleich mittels equals() relevant ist.  Was nicht zum Ergebnis von equals() beiträgt, kann auch für hashCode()ignoriert werden.
   
Daraus ergibt sich, dass man für eine Klasse hashCode() immer dann implementieren muss, wenn man auch equals() implementiert.  Vieles von dem, was wir in den letzten beiden Artikeln für equals() besprochen haben, gilt ganz analog auch für hashCode().

(quelle: http://www.angelikalanger.com/Articles/EffectiveJava/03.HashCode/03.HashCode.html)


# Polymorphie
https://falconbyte.net/java-polymorphie.php
Variablen in Java sind polymorph ("verschiedenartig"). Das bedeutet, dass eine Variable auf ein Objekt verweisen kann, dessen Typ entweder gleich dem deklarierten Typ der Referenzvariablen oder ein beliebiger Subtyp davon ist:


# Predicate Implementation
with more than one variable:   

Predicate:    
```java
   public interface Predicate<T>
   boolean test(T t);


    static Predicate<Integer> closedInverval(final int lowerBound, final int upperBound) {   
        if (upperBound < lowerBound) {    
            throw new IllegalArgumentException("lowerBound must be <= upperBound");    
        }   
        return value -> lowerBound <= value && value <= upperBound;   
    }   
    
    private static List<Integer> filterAll(final List<Integer> inputs,
                                           final Predicate<Integer> predicate) {
        return inputs.stream().filter(predicate).collect(Collectors.toList());
    }
```    
    main
      final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6);
      List<Integer> integers = filterAll(inputs, closedInverval(2, 4));
    
    
    
## Wire Logging
Damit sieht man alle HTTP ausgänge mit Parametern/Headern in der Konsole. 
Um diese ggf. nachzubauen

https://hc.apache.org/httpcomponents-client-4.5.x/logging.html

#### In die VM-Options eintragen:
``` 
-Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog
-Dorg.apache.commons.logging.simplelog.showdatetime=true
-Dorg.apache.commons.logging.simplelog.log.org.apache.http=DEBUG
-Dorg.apache.commons.logging.simplelog.log.org.apache.http.wire=ERROR
``` 


