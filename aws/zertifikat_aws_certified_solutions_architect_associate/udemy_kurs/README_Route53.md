### Video 75 - DNS 101

__What is DNS?__  

convert www-addresses to ip-addresses

__Top Level Domain__   
endungen wie .com / .gov / .uk

__Second Level Domain__  

.co.uk = co is the second level domain name   


__TTL__  
The length that a DNS record is cached on either the Resolving Server or the users own local PC is equal to the value of the "Time to Live" (TTL) in seconds.  
The lower the time to live, the faster changes to DNS records take to propagate throughout the internet.   


the lower the ttl - the faster changes to dns take to propagate to the internet

__Common DNS Types__   
- SOA Record
- NS Record
- A Record
- CNAMES
- MX Record
- PTR Record

__SOA Record__   
The SOA recoird stores information about:   
- The name of the server that supplied the data for the zone
- The administrator of the zone
- The current version of the data file
- The defualt number of seconds for the time-to-live file on resource records

__NS Record__  
NS = Name Server Records   
They are used by __Top Level Domain servers__ to direct traffic to the Content DNS server which contains the authoritative DNS records.

__A Record__  
A Record-Einträge verweisen auf eine IP adresse.

(further info: AAAA record (IPv6))

__CNAME__  
Canocical Name (CName)

- verbindet eine Domain mit einer anderen Domain.   
- bei der domain www.biograd-online.de kann ein cname eingetragen werden, um auf biograd-online.de zuzugreifen.   

__ALIAS RECORD__  
Alias records are used to map resource record sets in your hosted zone to Elastic Load Balancers, CloudFront distributions, or S3 buckets that are configured as websites.   
Alias records work like a CNAME record in that you can map one DNS name (www.example.com) to antoher 'target' DNS name (elb1234.elb.amazonaws.com)

⚠️ ⚠️ ⚠️ ⚠️ there is a crucial difference however:   ⚠️ ⚠️ ⚠️   
Key difference - a CNAME cant be used for naked domain names (zone apex record) You cant have a CNAME for http://acloud.guru, it must be either an __A record__ or an __Alias__.


__MX Record__   
is used for mail   

__PTR Record__   
is a reverse of a A-Record. Its a way of looking up a name against an ip-address.   
IP-Address -> NAME



__EXAM TIPS__   
- ELB (Elastic Load Balancer) do not have pre-defined IPv4 addresses; you resolve to them using a DNS name
- Understand the difference between an Alias Record and a CNAME
- Given the choice, always choose an Alias Record over a CNAME

### Video 76 - Route 53 - Register A Domain Name Lab

Es wurde ein Domain-Name registriert   

__EXAM TIPS__  
- You can buy domain names directly with AWS
- It can take up to 3 days to register depending on the circumstnances


### Video 77 - Route 53 Routing Policies Avsailable on AWS


The following routing policies are available with route53:   
- Simple Routing
- Weighted Routing
- Latency-based Routing
- Failover Routing
- Geolocation Routing
- Geoproximity Routing (Traffix Flow Only)
- Multivalue Answer Routing

Diese werden in den nächsten Videos erklärt:

### Video 78. Simple Routing Policy Lab

__Simple Routing Policy__  
If you choose the simple routing policy you can only have one record with multiple IP addresses.  
If you specify multiple values in a record, Route 53 returns all values to the user in a random order.

one record in your DNS and has multiple IP-Adresses  

man kann unterschiedliche ip adressen eingeben - von unterschiedlichen EC2-Instanzen.  
Ruft man die Domain auf, wird man auf die unterschiedlichen IP-Adressen geleitet.  


### Video 79 - Weightted Routing Policy Lab

Allows you to split your traffic based on different weights assigned.  

For example, you can set 10% of your traffic to go to US-EAST-1 and 90% to go to EU-WEST-1.   


__Health Checks__  
- You can set health checks on individual record sets
- If a record set fails a health check it will be removed from Route53 until it passes the health check  
- You can set SNS notifications to alert you if a health check is failed

### Video 80 - Latency Routing Policy

__Latency-Based Routing__  
Allows you to route traffic based on the lowest network latency for your end user (iw which region will give them the fastest reponse time).  

To use latency-based routing, you create a latency resource record set for the Amazon EC2 (or ELB) resource in each region that hosts your website.
When Amazon Route 53 receives a query for your site, it selects the latency resource record set for the region that gices the user the lowest latency. Route 53 then responds with the value associated with that resoruce record set. 

-> Der Benutzer wird auf die Instanz mit der geringsten Latenz geleitet.  


### Video 81 - Failover Routing Policy

__Failover Routing Policy__  
Failover routing policies are used when you want to create an active/passive set up. For example, you may want your primary site to be in EU-WEST-2 and your secondary DR Site in AP-SOUTHEAST-2.   

Route53 will monitor the health of your primary site using a health check.  

A health check monitors the health of your end points.  


-> wenn eine istanz kaputt geht (durch health check erkannt) wird auf eine andere Instanz geleitet.  


### Video 82 - Geolocation Routing Policy

Geolocation routing lets you choose where your traffic will be sent based on the geographi location of your users (ie the location from which DNS queries originate).  
For example, you might want all queries from Europe to be routed to a fleet of EC2 instances that are specifically configured for your European customers.
These servers may have the local language of your European customers and all prices are displayed in Euros.


-> man kann festlegen, dasss Europäische Besucher auf EU-WEST-1 geleitet werden und man kann festlegen, dass US Besucher auf US-EAST-1 geleitet werden.   


### Video 83 - Geoproximity Routing Policy

-> laut Aussage kein Inhalt der Prüfung / not in the exam   

⚠️ interessant - nochmal angucken

__EXAM TIP__
-> siehe video


### Video 83 - Multivalue Answer

__Multivalue Answer Policy__  
Multivalue answer routing lets you configure Amazon Route 53 to return multiple values, such as IP addresses for your web servers, in response to DNS queries. You can specify multiple values for almost any record, but multivalue answer routing also lets you check the health of each resource, so Route 53 returns only values for healthy resources

__This is similar to simple routing however it allows you to put health cehcks on each record set.__

-> its just simple routing with health checks












