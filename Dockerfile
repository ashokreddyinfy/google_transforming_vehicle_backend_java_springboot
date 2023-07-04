# Use an appropriate base image with Java pre-installed
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/gcp-0.0.1-SNAPSHOT.jar /app

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Set the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "gcp-0.0.1-SNAPSHOT.jar"]
