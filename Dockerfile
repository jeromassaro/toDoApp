# Build
FROM eclipse-temurin:21-jdk as builder

# Working Directory
WORKDIR /app

# Copy
COPY . .

# Build con Maven
RUN ./mvnw clean package -DskipTests

# Run
FROM eclipse-temurin:21-jre

# Working Directory
WORKDIR /app

# Copy jar file
COPY --from=builder /app/target/*.jar app.jar

# PORT
EXPOSE 8080

# Commandos
ENTRYPOINT ["java","-jar","app.jar"]
