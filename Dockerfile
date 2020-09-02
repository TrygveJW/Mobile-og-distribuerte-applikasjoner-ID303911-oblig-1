FROM payara/server-full:5.2020.4-jdk11

COPY ./target/fant-1.0-SNAPSHOT.war $DEPLOY_DIR


EXPOSE 8080

