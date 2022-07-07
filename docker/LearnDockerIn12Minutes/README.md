# Learn Docker in 12 Minutes 🐳
https://www.youtube.com/watch?v=YFl2mCHdv24


# Dockerile / Image / Container

`
Dockerfile -{build}-> Image -{run}-> Container       
`

a container is a running instance of an image   

a dockerfile is just a textfile with a list of steps to perform to create   
that image.

# the docker-file

content of the file:     
`FROM php:7.0-apache`    
`COPY src/ /var/www/html`    
`EXPOSE 80`     

## Description
`FROM php:7.0-apache`    
get/download the apache-webserver with php    

`COPY src/ /var/www/html`    
copy everything from out src-folder into /var/www/html on the server    

`EXPOSE 80`    
that container will listen on port 80    

# create image
go into the folder with the dockerfile and type:    
`docker build -t hello-world . `    
//`.` the location of the dockerfile    
//`-t`    
with that we created a new image.    

# run the image
now we need to run the image:    

`docker run -p 80:80 hello-world`    
// `-p` port 80 from the host to the port 80 of the container. The host is our pc.     

# try it

http://localhost:80/

# Volumes
we want to link to the src folder and the index.php     
so we can modify the index.php on our filesystem and refresh the page to get the modifications    
within the server.      


`docker run -p 80:80 -v C:\mk\dev\gitrepos\tutorials\docker\LearnDockerIn12Minutes\src:/var/www/html/ hello-world`

to mount a volume. we mount the folder `C:\mk\dev\gitrepos..` inside the container at `/var/www/html/`

now we can change the index.php and reload the browser.   
