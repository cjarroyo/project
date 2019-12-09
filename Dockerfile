FROM java:8-jdk-alpine

COPY ./target/project-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch project-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","project-0.0.1-SNAPSHOT.jar"]