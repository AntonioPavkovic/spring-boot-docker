FROM openjdk:17-alpine

WORKDIR /home/app

COPY pom.xml mvnw ./
COPY src src
COPY .mvn .mvn

RUN ./mvnw install -DskipTests

RUN cp target/spring-boot-docker.jar spring-boot-docker.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]