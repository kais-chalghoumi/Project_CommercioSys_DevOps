FROM openjdk:11-jre-slim
WORKDIR /app 
EXPOSE 8089

COPY target/DevOps_Project-0.0.1-SNAPSHOT.jar /app/DevOps_Project-0.0.1-SNAPSHOT.jar
#ADD target/DevOps_Project-0.0.1-SNAPSHOT.jar DevOps_Project-0.0.1-SNAPSHOT.jar
#ADD http://192.168.0.117:8081/repository/maven-releases/tn/esprit/DevOps_Project/0.0.1/DevOps_Project-0.0.1-SNAPSHOT.jar DevOps_Project-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/DevOps_Project-0.0.1-SNAPSHOT.jar"]

