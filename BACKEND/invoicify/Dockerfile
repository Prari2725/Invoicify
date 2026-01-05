# ===============================
# 1️⃣ Build stage
# ===============================
FROM docker.io/library/maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies first (cache friendly)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build JAR
RUN mvn clean package -DskipTests


# ===============================
# 2️⃣ Runtime stage
# ===============================
FROM docker.io/library/eclipse-temurin:17-jre

WORKDIR /app

# Copy JAR from build stage
COPY --from=builder /app/target/invoice-system-1.0.0.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
