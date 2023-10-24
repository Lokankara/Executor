FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY ./pom.xml ./pom.xml
COPY ./src ./src

RUN apk add --no-cache maven && \
    mvn clean package

CMD ["java", "-jar", "target/executor-service-1.0.jar"]
