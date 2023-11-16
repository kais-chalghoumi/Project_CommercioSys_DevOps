FROM openjdk:8-jdk-alpine

EXPOSE 8083

#ADD target/DevOps_Project-0.0.1-SNAPSHOT.jar  DevOps_Project-0.0.1-SNAPSHOT.jar
ADD http://192.168.1.114:8083/repository/maven-releases/tn/esprit/DevOps_Project/0.0.1/DevOps_Project-0.0.1.jar DevOps_Project-0.0.1.jar

ENTRYPOINT ["java", "-jar", "/DevOps_Project-0.0.1-SNAPSHOT.jar"]