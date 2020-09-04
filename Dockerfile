FROM payara/server-full:5.2020.4-jdk11

USER root
RUN mkdir /fant_images
RUN chown payara:payara /fant_images
RUN chmod 777 /fant_images
USER payara

COPY ./target/fant-1.0-SNAPSHOT.war $DEPLOY_DIR

EXPOSE 8080

CMD ["--deploymentDir", "/opt/payara/deployments", "--contextroot", "my"]



