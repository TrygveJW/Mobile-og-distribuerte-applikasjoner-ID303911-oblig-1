# Fant Server
Asignment part 1: the basic api part of the fant service



### usage

to start run 
``` mvn clean compile package && docker-compose up --build -V ```

you can peek the db @10.20.30.40:5432

most of the configs are in the docker compose file, the https and certs stuff will complain if the mail and url is not set

