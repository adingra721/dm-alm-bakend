FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
VOLUME /tmp
COPY --from=build /target/cima-alm-0.0.1-SNAPSHOT.jar cima-alm.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","solidarite-360.jar"]
