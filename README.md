# SpringOAuthExample #

## A simple example implementing separate Authorization Server
 and Resource Server using Spring OAuth. ##

### Prerequisite ###

* Java 8
* MySql (you can start docker container)
    - docker run -d -e  MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=auth --name auth-db -p 3306:3306 mysql


### Running ###

*  Auth Server 
    - cd auth-server
    - mvn clean install
    - mvn spring-boot:run

*  Resource Server
    - cd resource-server
    - mvn clean install
    - mvn spring-boot:run
    
### Get Access Token ###
 
* curl --request POST -u resource-server:secret "http://localhost:8888/auth/oauth/token?grant_type=password&username=anuj&password=secret"

### Access protected resource with access Token ###

* curl -H "Authorization:Bearer <AccessToken>" http://localhost:8081/protected/1