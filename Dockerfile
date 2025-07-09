# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 as builder
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 9393

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]


