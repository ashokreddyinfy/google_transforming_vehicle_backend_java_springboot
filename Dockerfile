# Use an appropriate base image with Java pre-installed
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/google_transforming_vehicle_backend_java_springboot.jar /app

# Expose the port on which your Spring Boot application runs
EXPOSE 9951

# Set the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "google_transforming_vehicle_backend_java_springboot.jar"]
