# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/exp-EMI-Caculation-0.0.1-SNAPSHOT.jar /app/exp-EMI-Caculation-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "emicalculator.jar"]
