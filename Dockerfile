FROM openjdk:17-alpine

ADD target/DevOps_Project-*.jar /DevOps_Project.jar

CMD ["java", "-jar", "/DevOps_Project.jar"]