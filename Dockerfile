FROM openjdk:11
EXPOSE 8080
ADD target/ClaculatorDevOps-0.0.1-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]