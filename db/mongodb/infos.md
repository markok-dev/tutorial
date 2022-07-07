URL: https://www.youtube.com/watch?v=pWbMrx5rVBE    
 
in den Ordner gehen:    
C:\Program Files\MongoDB\Server\4.2\bin    

# Console starten
befehl eingeben: `mongo`     

# clears the console
`command: cls`   

# shows the databases
`command: show dbs`    

# creates a new database "mycustomers" (it switch directly into the db)
`command: use mycustomers`   

# switch to a db
`use mycustomers;`

# shows the current databse
command: `db`

# creating a database-user
https://docs.mongodb.com/manual/reference/method/db.createUser/     

paste this into the console:
`
db.createUser({
	user: "mk",
	pwd: "1234",
	roles: ["readWrite", "dbAdmin"]
});
`

# create collections
MongoDB stores documents in collections. Collections are analogous to tables in relational databases.    
`db.createCollection('customers');`    

# show all collections
`show collections`    


# insert a document into a collection
`db.customers.insert({firstName:"Stipe",lastName:"Miocic"});`    

insert more then     
db.customers.insert([{firstName:"Steven",lastName:"Smith"}, {firstName:"Kevin",lastName:"Rendleman", gender:male}]);    
(i): it was passible to add a gender for Rendleman (that was not defined for Stipe)    

# see documents in a collection    
`db.customers.find();`     
or with formatation:    
db.customers.find().pretty();    

# find command
`db.customers.find({firstName:"Stipe"});`

find with logical or:    
`db.customers.find({$or:[{firstName:"Stipe"},{firstName:"Kevin"}]});`

# count
`db.customers.find().count()`

# limit
db.current.find().limit(4)

# for each
db.customers.find().forEach(function(doc){print("Customer Name: " + doc.firstName)});


# sorting
db.customers.find().sort({lastName:1});     
set 1 means desc order. else -1 for ascending.    

# update documents    
-> goal: add a gender for Stipe    
command:    
`db.customers.update({firstName:"Stipe"},{firstName:"Stipe", lastName:"Miocic", gender:"male"});`   
we are searching for a entry with firstName = "Stipe". This is only for a test-purpose. In reality we would    
search for an id.    
Then we add a new column "gender". We need to add the Lastname also, otherwise it would be overwritten!!    
to avoid that, use this command:

# SET - update command 
just set new value, dont overwrite other.     
`db.customers.update({firstName:"Steven"},{$set:{gender:"male"}});`    

add age-filed to steven:    
`db.customers.update({firstName:"Steven"},{$set:{age:45}});`    


# increment field within an object
`db.customers.update({firstName:"Steven"}, {$inc:{age:5}})`    
increments the age for +5 years

# remove a field (UNSET)
`db.customers.update({firstName:"Steven"}, {$unset:{age:1}});`     
removes the field "age" from Steven.

# update an object, if it doesnt exists: create it
`db.customers.update({firstName:"Mary"}, {firstName:"Mary", lastName:"Samson"},{upsert: true});`
it is handled via the parameter: upsert    

# rename a column (gender -> sex)
`db.customers.update({firstName:"Steven"}, {$rename:{"gender":"sex"}});`


# remove a document
db.customers.remove({firstName:"Steven"});





