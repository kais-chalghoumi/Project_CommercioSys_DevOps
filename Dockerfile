FROM maven:3.8.2-jdk-8
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} kaddem-2.0.0.jar
ENTRYPOINT ["java", "-jar" ,"/kaddem-2.0.0.jar"]
EXPOSE 8089