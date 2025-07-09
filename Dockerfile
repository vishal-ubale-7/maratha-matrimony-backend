# Use an official Java runtime as a parent image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the container (adjust if your jar has a different name)
COPY target/maratha-matrimony-0.0.1-SNAPSHOT.jar app.jar


# Expose port
EXPOSE 9393

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

