FROM openjdk:11
ADD target/api-docker.jar api-docker.jar
ENTRYPOINT ["java", "-jar","api-docker.jar", "--spring.profiles.active=docker"]
EXPOSE 8080