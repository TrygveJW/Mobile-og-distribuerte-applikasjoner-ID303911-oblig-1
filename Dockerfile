FROM tomee:8.0.2-plume

ENV SQLURL="jdbc:postgresql://localhost:5432/docker"
ENV POSGRESS_USER="docker"
ENV POSGRESS_PASSWORD="mysecretpassword"


# this is requiered to alow the application to run insted of the welcome one
RUN ["rm", "-fr", "/usr/local/tomee/webapps/ROOT"]
COPY ./target/fant_api-1.0-SNAPSHOT.war /usr/local/tomee/webapps/ROOT.war
#COPY ./target/Server.war /usr/local/tomcat/webapps/Server.war

EXPOSE 8080

CMD ["catalina.sh", "run"]