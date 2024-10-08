FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/weather-api-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080