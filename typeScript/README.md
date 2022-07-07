### typeof
```Typescript
if (typeof userInput === 'String') {   
}
```

### let and const

cons = constants - cant be changed after a assignment

### any VS unknown
Video 29 in Udemy  

unknown is a bit more restrictive



### Generic Utility Types (Video 101)
just exists in TypeScript - not in javaScript. 

Partial<Curse>
  
__Readonly__  
`const names: Readonly<string[]> = ['a', 'b'];`    
so you cant add additionally values - you can just read the values from the array   
names.push('x'); // error
names.pop(); // error



### Debugging
im in einer Codezeile stehen zu bleiben, folgendes Eintragen:   
`debugger`


### union types
username: string | null = null;


### portierung von purem javaScript zu typescript

1. javaScript aus html-datei in eigene datei verlagern (index.ts) -> in eine .ts-Datei (Typescript)
2. die daraus generierte .js datei in die html-datei einbinden (im header-bereich):
<script src="index.js"></script>
3. npm init ausführen (dort gibt man dann auch index.js ein bei einer frage)
4. damit jquery benutzt werden kann folgendes ausführen:
npm install @types/jquery

6. für das transpilieren in .ts muss eine tsconfig.json vorhanden sein. (beachte beispiel tsconfig.json - kann so verwendet werden)
5. damit man zu typescript transpilieren kann in visualStudioCode strg+shift+b drücken

6. es wird die index.js erzeugt
