F: 
wo kommen bei der expenseapp die transpilierten skripte hin? Früher hatten wir ein "outDir" in der tsconfig

A: 
du musst das run target  cordova* benutzen
starten geht aus vscode heraus mit dem task      cordova-serve-browser
der startet ein webpack + webserver im hintergrund ... die compilierten js liegen dann nur im ram von dem server und werden an den browser von dort geliefert
 
F:
kann es starten, läuft alles soweit. ich hab mich nur gefragt, wo die JavaScript-Files landen. ich sehe die nirgends
wie deployst du das? du braucst ja nur die javascript-files, oder?

A:
zum deployen klar, da brauchst du die 
dafür gibt es auch targets... cordova-build-*


## Anwendung starten

Die Anwendung wird so gestartet:  
 `npm run cordova-serve-browser`
 
 dafür wurde dieses hier benutzt:  
 Link: https://github.com/m0dch3n/vue-cli-plugin-cordova
das ist das cordova-plugin für die vue cli  

in der `package.json` gibt es entsprechende Einträge:  

```
"cordova-serve-android": "cross-env CORDOVA_PLATFORM=android vue-cli-service cordova-serve-android",
"cordova-serve-browser": "cross-env CORDOVA_PLATFORM=browser vue-cli-service cordova-serve-browser",
"cordova-serve-electron": "cross-env CORDOVA_PLATFORM=electron vue-cli-service cordova-serve-electron",
```

Diese Einträge gelangen in die `package.json` durch den Command `vue add cordova`.  
Siehe oben aufgeführten Link für die vollständige Installation. 

