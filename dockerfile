FROM ubuntu:latest as build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .
RUN sudo ./mvnw bootJar --no-daemon

FROM openjdk:21-jdk-slim
EXPOSE 8080

COPY --from=build /build/libs/ing_backend-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]