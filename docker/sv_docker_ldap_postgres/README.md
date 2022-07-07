# docker compose starten
`docker-compose up ldap`


# LDAP / Docker

Das LDAP im Docker ist "opendj" und nicht "opends".    
Um das verwenden zu können, muss man noch Änderungen in folgenden Klassen machen:    
com.scopevisio.erp.server.userrepository.ldap.LdapRegion    
dort LdapRegion.EM zurückgeben

und in     

com.scopevisio.erp.api.internal.LdapRegion
das gleiche
