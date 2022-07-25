FROM openjdk:11
EXPOSE 8080
COPY ./target/carApp-0.0.1-SNAPSHOT.jar carApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","carApp-0.0.1-SNAPSHOT.jar"]