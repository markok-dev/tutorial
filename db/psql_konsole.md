## Links
- https://www.postgresqltutorial.com/psql-commands/


# Login 

databasename is: '7511fccf-3dd4-40c1-9136-6cd725435539':   
`psql 7511fccf-3dd4-40c1-9136-6cd725435539 postgres -h localhost`


`psql -U postgres -d financeViewDB`    
-U = User   
-d = Database   



## format output

`\x auto`   
info: vor dem select einmal eingeben   

# enter a database
\c databaseName


## Tabellenbeschreibung - describe table
\d+ tablename



# SCHLIESSEN DER KONSOLE

`\q`


# Clear Console

`\! clear`


# Commands aus einer Datei ausführen
in dem Ordner, aus dem die Kondole aufgerufen wurde, eine datei mit sql-commands ablegen.    
dann in der Konsole:     
`\i filename`


# BACKUP ERSTELLEN / EINSPIELEN

info page: https://axiomq.com/blog/backup-and-restore-a-postgresql-database/    
backup erstellen:   
`pg_dump -U postgres 7511fccf-3dd4-40c1-9136-6cd725435539 > /c/Users/marko.kovacevic/Desktop/backup_15122019.sql`   
   
backup einspielen (vor dem Einspielen ggf. Tabellen über Oberfläche löschen):    
`psql -U postgres -d financeViewDB -f /c/Users/MK/Desktop/financeViewBackup_15122019.sql`  


