# Cache depdency as layer and stage
# JDK - To big size, we dont want make big images $$$$$$
FROM maven:3.9-eclipse-temurin-22-jammy AS base
COPY pom.xml /build/
WORKDIR /build/
RUN mvn --batch-mode dependency:go-offline dependency:resolve-plugins

# Only build, maybe you need this to run test latter on another stage or create a dev stage with vscode remote, etc...
FROM base AS build
COPY --from=base /root/.m2 /root/.m2
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn -P dockerfile --batch-mode --fail-fast package

# production ready stage!
# JRE size is less that a JDK
FROM eclipse-temurin:22-jre AS staging
WORKDIR /srv
#mm... the version in the name is a little ugly :s
COPY --from=build /build/target/api-example-0.0.1.jar ./api-example-0.0.1.jar
# Another common strategy is use a entrypoint.sh
CMD ["java", "-jar", "./api-example-0.0.1.jar"]