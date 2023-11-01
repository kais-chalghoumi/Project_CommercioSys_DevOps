# Utilisez une image de base pour Java (par exemple, OpenJDK)
FROM openjdk:1.8

# Définissez le répertoire de travail


# Copiez le jar de votre application Spring dans l'image Docker
COPY target/DevOps_Project-0.0.1-SNAPSHOT.jar app.jar

# Exposez le port sur lequel votre application écoute
EXPOSE 8083

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "app.jar"]
