FROM openjdk:8-jdk-alpine

EXPOSE 8083

ADD http://192.168.0.117:8081/repository/maven-releases/tn/esprit/DevOps_Project/0.0.1/DevOps_Project-0.0.1.jar DevOps_Project-0.0.1.jar

ENTRYPOINT ["java", "-jar", "/DevOps_Project-0.0.1.jar"]