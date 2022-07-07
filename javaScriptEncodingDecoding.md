## Special character check
check a string for special character

solved:    
    `function specialCharacterCheck(password: string) {`    
        `let foundSpecial:RegExpMatchArray = password.match(/[^a-zöäüß \d]/ig) as RegExpMatchArray;`    
        `return foundSpecial != null && foundSpecial.length >= 3;`    
    `}`      

alles was kein a-z bzw. A-Z und keine Zahl 0-9 ist, ist ein special character     
umlaute und das ß sowie das leerzeichen werden nicht als special character erkannt 




## Encoding / Decoding : JavaScript / Java

### JavaScript


### URI encoding
Auf der JavaScript-Seite sollte encodeURIComponent verwendet werden.    
Es wurde fehlerhaft die Funktion "encode" verwendet.    
encode hat z.B. das + Zeichen nicht encoded und es blieb so.    
Dann wurde es von Java von der unten aufgeführten Methode verarbeitet uns aus + wurde ein Leerzeichen.    


`var data = "code=" + codeParam + "&password=" + encodeURIComponent(password1);`    
`let response = await fetch(`    
`	url,`    
		`{`
            `method: 'POST',`    
            `body: data`    
        `});`
		
		

### Java
`URLDecoder.decode(fields[0], "UTF-8");`    
Auf Java-Seite ist das der richtige Part.    



