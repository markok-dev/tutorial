### commands

`npm install`   

`npm list`   

`npm update`   

### package-lock.json
Diese Datei einchecken. Wenn man `npm install` ausführt hat man packages mit einem spezifischen Versionsstand.   
Führt jemand anderes `npm install` aus, kann es sein, dass bestimmte packages updates hatten. Die Folge ist, dass zwei Entwickler unterschiedliche Versionen auf dem Rechner haben. 
In der `package-lock.json` stehen die exakten Versionen, die beim `npm install` installiert wurden.
Führt der zweite Entwickler nun `npm install` aus, bekommt er genau die Versionen die in der package-lock.json stehen.

### version handling 
`^4.1.1`  installiert alle updates aber nicht die major version

`~2.2`  installiert alle updates aber nicht die minor version


### videos
https://www.youtube.com/watch?v=P3aKRdUyr0s    //npm, versionen(major, minor, patch), commands 
