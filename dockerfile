
FROM maven:latest
WORKDIR /app
COPY src ./src
COPY pom.xml ./
