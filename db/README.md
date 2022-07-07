
# Links

- Indizes    
https://use-the-index-luke.com/de    
- SQL Abfragen üben    
https://sqlzoo.net/    



# add character/String in output
`select 'x' || "EMAIL" || 'x' from "FOLDERUSER";`

# time analysieren

`EXPLAIN SELECT * FROM XXX;`    
generates the query plan by estimating the cost

`EXPLAIN ANALYSE SELECT * FROM XXX;`    
actually executes the query.


# format timestamp to string
`select TO_CHAR(TO_TIMESTAMP(purchasedatets / 1000), 'DD/MM/YYYY HH24:MI:SS'), * from depotentry`    

`select TO_TIMESTAMP("CREATEDTS" / 1000), * from "BNK_BANKSTATEMENT"`

purchasedatets is a bigdecimal column.    
there is a timestamp stored - for example: `1559512800000`    
the output would be in that case: 03/06/2019 00:00:00    



# Abfragen
- Equal (=)    
- LIKE    
- ILIKE    
- Reguläre Ausdrücke (~)     
	SELECT * FROM journal WHERE documenttext ~ '(.*[^\\d]|^)6034214([^\\d].*|$)'

# Nach Tags suchen

Es wird im Feld "TAGS" der Kontakte gesucht:

`SELECT *`    
`FROM`     
`"public"."ENT_KONTAKT"`     
`WHERE`  
`(  ( "USEDASCONTACT"= '1'  ) AND ( "ORGANISATION"= 7  )  ) AND`     
`( string_to_array(lower("TAGS") ,' ')@>string_to_array( lower( 'bonn fitness' ),' ') )`       


# Abfragestatistik
`CREATE OR REPLACE VIEW table_stats AS`    
`SELECT`    
 `stat.relname AS relname,`    
 `seq_scan, seq_tup_read, idx_scan, idx_tup_fetch,`    
 `heap_blks_read, heap_blks_hit, idx_blks_read, idx_blks_hit`    
 `FROM pg_stat_user_tables stat`    
 `RIGHT JOIN pg_statio_user_tables statio`    
 `ON stat.relid=statio.relid;`    

### Statistik zurücksetzen
`SELECT pg_stat_reset();`

### Statistik zu einer Tabelle annzeigen
Mit diesem Befehl kann man sich die Statistik zu einer Abfrage anzeigen lassen.
Ablauf: view erzeugen, Statistik zurücksetzen, Statistik mit unten stehender Abfrage abfregen

`SELECT * FROM table_stats WHERE relname='journal'`

# Joins
https://www.w3schools.com/sql/sql_join.asp

## Left Join
The LEFT JOIN keyword returns all rows from the left table, even if there are no matches in the right table.   
In some databases LEFT JOIN is called LEFT OUTER JOIN



## Right Join
The RIGHT JOIN keyword returns all the rows from the right table, even if there are no matches in the left table.
In some databases RIGHT JOIN is called RIGHT OUTER JOIN


## Inner Join
INNER JOIN is the same as JOIN

The INNER JON keyword returns rows when there is at least one match in both tables.   

`select kontakt."FIRSTNAME", kontakt."LASTNAME", users."CONTACTID", users."UID",* from "KONTAKT" as kontakt JOIN "USER" as users ON kontakt."ID" = users."CONTACTID"`




# Trigram
muss vorher installiert werden    
`create extension "pg_trgm"`    

`SELECT show_trgm('PostgreSQL')`



select relname, relpages, reltuples from pg_class where relname = 'journal'


# Index-Creation
- b-tree index    
`CREATE INDEX  <indexName> ON <tableName>(LOWER(column))`   

- trigram GIN-Index:    
`CREATE INDEX <indexName> ON <tableName> USING gin(column gin_trgm_ops)`    
    
# Index Erstellung und die groß und Kleinschreibung
`CREATE INDEX idx_documenttext_btree ON journal(documenttext varchar_pattern_ops);`

EXPLAIN ANALYSE SELECT * FROM journal where documenttext = 'RE/3968478x';    
Der Index wird benutzt.

Ein Index auf einen String kann ihn nur so finden, wie er in der Datenbank hinterlegt wurde.    
Um dieses zu umgehen, kann man beide Seiten in Großbuchstaben wandeln:    

`EXPLAIN ANALYSE SELECT * FROM journal where UPPER(documenttext) = UPPER('RE/3968478');`    
Dann wird der Index aber nicht benutzt.    



    
# Full Text Search

`select to_tsvector('german', 'Die Indizierung von Spalten macht Spaß');`

`select * from ts_debug('german', 'Die Indizierung von Spalten macht Spaß');`

## index creation for full text search
`CREATE INDEX indexName  ON tablename using gin(to_tsvector('german', column));`


