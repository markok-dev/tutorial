# Postgres + docker

## Das Image von Postgres mit der Version 9.6 holen:    
`docker pull postgres:9.6`   

frage: warum haben wir hier kein dockerfile?    

## das Image starten
Auf der Seite von Postgres (https://hub.docker.com/_/postgres) steht, wie man postgres starten kann:   
start a postgres instance    
$ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres    

wir führen demnach aus:    
`docker run --name scopePG -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:9.6`    
`-e` is an environment variable    
`-d` is the detached mode    

# Image starten wenn down 
Falls das image gerade nicht läuft, es aber mit dem obigen Befehl ausgeführt wurde, kann man es so starten:
`docker start scopePG`

## container starten
Wenn der container aktuell nicht läuft, kann man ihn so starten:   
`docker start scopePG`    


## bash öffnen
`docker exec -it scopePG bash`    

danach folgenden command:    
`psql -U postgres`

`create database "7511fccf-3dd4-40c1-9136-6cd725435539";`    
`create database "global-locks";`    

mit `\c 7511fccf-3dd4-40c1-9136-6cd725435539` enter the database    




docker run --name scopeTEMP -e POSTGRES_PASSWORD=password -d -p 5433:5433 postgres:9.6
