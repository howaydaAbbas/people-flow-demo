#FROM openjdk:11-jdk-slim
FROM maven:3.6.1-jdk-11 AS build
LABEL maintainer="howayda.gamal@gmail.com"

#FROM maven:3.6-alpine
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN mvn package -DskipTests
ENV JAR_FILE=target/people-flow-0.0.1-SNAPSHOT.jar
RUN mv ${JAR_FILE} /peopleFlow.jar
ENTRYPOINT ["java","-jar","peopleFlow.jar"]