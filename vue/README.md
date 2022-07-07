
### Vue 
is a component-bases UI framework   
other Frameworks: Angular, React

## vue initialisieren
`Vue.createApp()`    


### Sections of Vue
you can only acces these things within the v-tags in html:   

Data: - this is a Function
Methods: - takes an Objects 

### SPA
Single Page Application.   
Server only sends one HTML page, thereafter Vue takes over and controls the UI.    
Anschließend werden nur noch neue Daten (z.B. per REST call) nachgeschoben.    

### Shorthands 
aus `v-bind:href` wird  `:href="url"`   

`v-on:click` wird  `@click`    

### Event-Bindung VS Data-Bindung
__Data-Bindung:__ wenn man in dem HTML-Teil auf eine Variable zugreift: `{{ maVariable }}`   

__Event-Binding:__ wenn man nach dem klick (zb auf ein button) eine methode in javaScript/TypeScript ausführen möchte.   

### Binding - v-bind

https://vuejs.org/v2/guide/syntax.html#Shorthands


Damit verbindet man Variablen/Methoden mit HTML-Elementen / -Attributen.   
Wird eher benutzt um Attribute von Tags dynamisch zu setzen.   

```html
<a href="www.vue.com">GO TO VUE</a>

//Beispiel mit vue mit einem Link zum Data-Part in dem die Variable vueLink vorhanden ist und dynamisch befüllt werden kann
//Attribut href wird also dynamisch befüllt

<a v-bind:href="vueLink">GO TO VUE</a>
```

### v-on // Actions an HTML-Elementen definieren

```
<button v-on:click="add()">Add</button>

// only the function-name (without brace) is also possible:
<button v-on:click="add">Add</button>  

// also possible - arguments:
<button v-on:click="add(6)">Add</button>
```
there are more events: mouseEnter, mouseLeave...   
event for typing into a text-field: input-event   
`v-on:click.right` // only react to a right click   
`v-on:keyup.enter="methodToExecute"` // auf enter reagieren

### v-model
`v-model` is a shortcut for `v-bind:value` and `v-on:input`   
we are listening and we write the value back = two way binding

### v-bind:value + v-on:input VS v-model
```
input type="text" v-bind:value="name" v-on:input="setName($event, 'Schwarzmulla')" /> 
```
Hier erledigt `v-bind:value` den Weg von JavaScript zu HTML. Hier kann man den Wert vom Input-Field aus JavaScript steuern. (JavaScript->HTML).   
Tippt man, wird dadurch jedoch nicht die Variable 'name' geupdated. Dafür brauch man den `v-on:input` - der ruft die setName mit dem `event` auf.   
Über den event kommt man an die Eingabe, die im Textfield getätigt wurde. (HTML -> JavaScript) 

__v-model__   
Dies alles kann man sich sparen, wenn man `v-model` benutzt:   
Tippt man, wird die Variable geupdated (HTML -> JavaScript)   
Und ändert man z.b. durch eine Methode die Varibale, wird sie automatisch im HTML geupdated (JavaScript -> HTML)   


```
<input type="text" v-model="modelName" /> 
```




### computed
```
Your Name: {{ fullName }}  //computed properties werden ohne Klammern "()" aufgerufen 
```
__name computed mathods like data-fields!__   
eine computed property muss nicht zusätzlich im data-bereich angelegt sein.   
hier packt man alles rein was sich nicht immer ändern soll - also auch nicht immer ausgeführt werden soll.    
Methods brauch man trotzdem - diese werden aufgerufen mit `v-on:click` da referenziert man auf Methoden und nicht computed   
computed behält die variablen im blick und nur wenn sich der wert dieser variablen ändert, wird die watcher metode aufgerufen.   
z.b: eine watcher methode die vorname und nachname-variablen benutzt. ändert sich eine von denen, wird der watcher aufgerufen um diese aneinander zu packen.

### watchers
not used directly in the template.  
watcher kann man auf variablen im data und computed bereich setzen!
Man kann Watcher auf Variablen setzen. Die Watcher heissen wie die Variablen-namen. Immer wenn sich der Variablenwert ändert, wird die watcher-Methode aufgerufen.
Aufgabe eines watchers ist z.b zu überprüfen, dass der wert eines counters nicht über 50 kommt.

### v-if, v-else, v-else-if AND v-show
- Ein `v-else` oder `v-else-if` muss direkt nach einem `v-if` folgen. Da dürfen keine weiternen Tags zwischen sein.   

- Ein `v-if` entfernt tatsächlich die Tags im DOM. Sie werden dann tatsächlich nicht angezeigt. Nicht so beim `v-show` - dort wird es mit css disabled

- Use `v-show` for elements that state switches a lot. Because of the performance. In `v-if` adding and removing elements costs performance.


### event-object übergabe
in Methods ist die Methode "setName(lastname)" durch klicken in einem Textfield, möchte man den event haben. Das Problem ist, dass man bereits ein Parameter hat - den lastname.   v-on:input="setName($event, '')"
`setName(event, lastname)`




### Data Binding with HTML (v-html)
Normalerweise wird html-code, der mit einer Variable verbunden ist, nicht interpretiert. 
Möchte man aber, dass die gebundene Variable html code enthält, der auch interpretiert werden soll (z.B. "<b>Das ist Fett</b>"), macht man dies so:
```html
<p v-html="outputGoal()">
```


### components
are generally registered in the main.js.   
this type of component registration is called "global components"   
Global Components you can use anywhere in your Vue app - i.e. in any template    
```
const app = createApp(App);
app.component('the-header', TheHeader);
app.component('base-badge', BaseBadge);
```

#### <style> in a component
if you define css-styles in one component, it will be available to all components.   
you can prevent that with the 'scoped' attribute:
<style scoped> CSS </style>

### Slots
`v-slot:header` kann auch so geschrieben werden: `#header`

### vue2 vs vue3
In Vue2 brauchte man in jedem template einen root-div tag. Unter dem kamen dann alle anderen Elemente.  
In Vue3 ist dies nicht mehr notwendig!   
Dies heisst "Fragments" - Video 122 - 

  
 
  
