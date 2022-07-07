https://www.compose.com/articles/mastering-postgresql-tools-full-text-search-and-phrase-search/

https://www.postgresql.org/docs/9.5/textsearch-tables.html


# Full Text Search

Man kann eine Volltextsuche auf einer Spalte direkt durchführen.   
Oder man kann eine extra Spalte mit dem Typ TSVECTOR erstellen.
Beide Beispiele werden hier gezeigt.


## with extra column TSVECTOR

`CREATE TABLE documents (`       
    `document_id SERIAL,`    
    `document_text TEXT,`    
    `document_tokens TSVECTOR,`    
    `CONSTRAINT documents_pkey PRIMARY KEY (document_id)`    
`)`   

## without extra column 

`CREATE TABLE documents (`       
    `document_id SERIAL,`    
    `document_text TEXT,`        
    `CONSTRAINT documents_pkey PRIMARY KEY (document_id)`    
`)`   


`INSERT INTO documents (document_text) VALUES`    
`('Pack my box with five dozen liquor jugs.'),`    
`('Jackdaws love my big sphinx of quartz.'),`    
`('The five boxing wizards jump quickly.'),`    
`('How vexingly quick daft zebras jump!'),`    
`('Bright vixens jump; dozy fowl quack.'),`    
`('Sphinx of black quartz, judge my vow.');`    
`

## Query for table without extra column
`SELECT document_text`    
`FROM documents`    
`WHERE to_tsvector('german', document_text) @@ to_tsquery('german', 'boxing');`    

## Query for tables with extra column
### first we need to fill the extra-column 
`UPDATE documents d1`      
`SET document_tokens = to_tsvector(d1.document_text)`   
`FROM documents d2;` 



