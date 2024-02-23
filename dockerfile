FROM openjdk:17-jdk-alpine
COPY target/evaluation-system-backend-0.0.1-SNAPSHOT.jar evaluation-system.jar
ENTRYPOINT ["java","-jar","/evaluation-system.jar"]
