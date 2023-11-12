# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the Spring Boot application
RUN ./mvnw clean install -DskipTests

# Expose port 8080
EXPOSE 8080

# Start the Spring Boot application when the container runs
CMD ["java", "-jar", "target/*.jar"]

