FROM openjdk:11
EXPOSE 8080
ADD target/ClaculatorDevOps-0.0.1-SNAPSHOT calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]