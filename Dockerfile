FROM maven:3.8.6-jdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11
EXPOSE 8080
COPY --from=build usr/src/app/target/carApp-0.0.1-SNAPSHOT.jar /usr/app/carApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/carApp-0.0.1-SNAPSHOT.jar"]
