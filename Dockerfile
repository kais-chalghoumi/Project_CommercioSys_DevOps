FROM openjdk:8-jdk-alpine

EXPOSE 8083

ADD target/DevOps_Project-0.0.1-SNAPSHOT.jar  DevOps_Project-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/DevOps_Project-0.0.1-SNAPSHOT.jar"]