# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 as builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 9393
ENTRYPOINT ["java", "-jar", "app.jar"]
