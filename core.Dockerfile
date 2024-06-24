FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY checkstyle-config.xml .
COPY checkstyle-suppressions.xml .
COPY common/pom.xml common/
COPY core-service/pom.xml core-service/
RUN mvn dependency:go-offline
COPY common/src common/src
COPY core-service/src core-service/src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/core-service/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]