# linux commands

### chmod
Zugriffsrechte ändern

Beispiel:  
`chmod +x gradlew` //Grant execute permission for gradlew

### duplicate filecontent
`x=$(cat test.txt) && echo "$x" >> test.txt`

### find 
Info-Seite: https://wiki.ubuntuusers.de/find/    
<code>find -name *.txt</code>    
findet alle txt-files

<code>find . -name FirstMapExample</code>    
Findet alle Files die mit "FirstMapExample" beginnen im aktuellen und allen darunterliegenden Verzeichnissen


### GREP COMMAND
https://stackoverflow.com/questions/12516937/how-to-grep-recursively-but-only-in-files-with-certain-extensions/35280826#35280826

`grep --color -rn "marko.kov*" --include=*.{module,inc,php,js,css,html,htm} ./`


|Parameter | Erklärung
|----------|-----------
|--color   | farbige Hervorhebung in der Konsole der gesuchten wörter    
|-i        | case insensitive-search    
|-n        | print line-number of the found string    
|-w        | nur ganzes  Suchwort suchen    
|-r 			 | rekursiv die ordner runter aufrufen   
|-l        | nur den Dateinamen ausgeben in dem das Suchwort vorkommt


# alias

### show all aliases
`alias`

### define alias 
alias gotoscope="cd /mnt/c/work/dev/gitrepos/platform"

### define within git-bash
der Pfad wird ohne `/mnt/` angegeben  
``` bash
cd ~
vi .bashrc
-> add line:
alias gotoscope='cd /c/work/dev/gitrepos/platform'
```

# txt-Dateien mit vielen Details in einem Ordner anzeigen

ls -lisa *.txt   


