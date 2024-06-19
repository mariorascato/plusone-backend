FROM maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/ing_backend-1.jar spring.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring.jar"]