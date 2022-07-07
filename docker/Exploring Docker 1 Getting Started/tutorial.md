# Exploring Docker [1] - Getting Started - URL:
https://www.youtube.com/watch?v=Kyx2PsuwomE&t=107s

### COMMAND OVERVIEW
https://gist.github.com/bradtraversy/89fad226dc058a41b596d586022a9bd3    
(die datei ist auch im Ordner vorhanden docker-help.md)    


!!!!!!!!!!!!!!!!!!!!!!!!!   
Alle commands in der windows power-shell ausführen!!!     
(NICHT IN DER GIT BASH)    
!!!!!!!!!!!!!!!!!!!!!!!!!

### WORDINGS
- dockerfile
- image    
- container

dockerfile -{build}-> image-{run}-> container

aus einem image wird ein container gebaut.    

### get apache
`docker container run -d -p 8081:80 --name myapache httpd`    
//-p
this first port is the port of your host ->your your local mashine    
and the second one is the port of the container.

-> ausserhalb über den ersten port erreichbar   
nach dem ausführen wird, falls nicht vorhanden, wird das image "httpd" gepulled    
im browser aufrufen: http://localhost:8081/


### get nginx - its a http-server. like apache.     

`docker container run -it -p 80:80 nginx`

//it = interactive mode - in the foreground - eg: we can see logs in the console 
nach dem ausführen auf:    
localhost:80     

it is running on a container! not on my mashine.


### get mysql
`docker container run -d -p 3306:3306 --name mysql --env MYSQL_ROOT_PASSWORD=123456 mysql`    
es wird mySql geholt und eine umgebungsvariable gesetzt: MYSQL_ROOT_PASSWORD    
siehe: https://hub.docker.com/_/mysql    



### running in the backgroud
`docker container run -d -p 8080:80 --name mynginx nginx`    
im browser aufrufen: http://localhost:8080/

### stop a container (without removing)
docker container stop mysql (mysql is the name nof the image, list them first)

### removing a container
`docker container rm myapache`    
you cannot remove a running container. we need to force that with a -f    
`docker container rm myapache -f`    

### remove all container
`docker rm $(docker ps -aq) -f`    

### hub.docker.com
www.hub.docker.com

there are images    
search there for nginx    

### vorhandene container anzeigen

`docker container ls`    
shows us running containers    
same command: `docker ps`    

`docker container ls -a`    
shows all containers. if there are running or not.

### modify files within a container - nginx here
goal: we want to change the index.html of the server.     
the index.html is located here: /usr/share/nginx/html    

`docker container exec -it mynginx bash`     
then type "ls". all folders are shown.
the webroot in nginx is in: usr/share/nginx/html/
there is an index.html-file.
we can edit it there. But we want to create a volume to map this folder.    

-> add a bind-mount    
`docker container run -d -p 8080:80 -v C:\mk\dev\dockerTest:/usr/share/nginx/html --name nginx-website nginx`    
es kommt ein prompt von docker ob man das wirklich will.     
nun in diesen dockerTest ordner einen index.html file anlegen und editieren.   
danach http://localhost:8080/ aufrufen. Es wird nun diese index.html geladen!    

### create a dockerfile/create a image

`docker image build -t devmk/nginx-website .`    

and then  `docker images`    
now we got the image. we can now create container from that.     

`docker container run -d -p 8082:80 devmk/nginx-website`    

### push image to docherhub

`docker push devmk/nginx-website`    





