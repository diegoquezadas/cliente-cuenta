# Build stage
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY --from=build /app/target/cliente-persona-service-0.0.1-SNAPSHOT.jar cliente-persona-service.jar
ENTRYPOINT ["java","-jar","/cliente-persona-service.jar"]
