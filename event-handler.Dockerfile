FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY checkstyle-config.xml .
COPY checkstyle-suppressions.xml .
COPY common/pom.xml common/
COPY core-service/ core-service/
COPY event-handler/ event-handler/
RUN mvn dependency:go-offline
COPY common/src common/src
COPY core-service/src core-service/src
COPY event-handler/src event-handler/src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /app/event-handler/target/*.jar application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "application.jar"]