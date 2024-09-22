FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/api-example-0.0.1.jar
COPY ${JAR_FILE} app_api-example.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_api-example.jar"]