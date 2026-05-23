# ==========================================
# BUILD STAGE
# ==========================================
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Application build directory
WORKDIR /build

# Copy pom.xml first for dependency caching
COPY pom.xml .

# Download dependencies separately
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build application
RUN mvn clean package -Dmaven.test.skip=true


# ==========================================
# RUNTIME STAGE
# ==========================================
FROM gcr.io/distroless/java17-debian12

# Application runtime directory
WORKDIR /app

# Copy generated JAR from build stage
COPY --from=build /build/target/*.jar app.jar

# Application port
EXPOSE 8080

# Run as non-root user
USER nonroot:nonroot

# JVM optimized for containers
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75","-XX:+ExitOnOutOfMemoryError","-jar","/app/app.jar"]