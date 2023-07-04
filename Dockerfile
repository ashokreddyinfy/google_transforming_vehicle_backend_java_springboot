# Use an appropriate base image with Java pre-installed
FROM adoptopenjdk:11-jdk-hotspot
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code of your Spring Boot application into the container
COPY . /app

# Build the Maven project and package the Spring Boot application
RUN mvn package

# Expose the port on which your Spring Boot application runs
EXPOSE 9955

# Set the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "gcp-0.0.1-SNAPSHOT.jar"]
