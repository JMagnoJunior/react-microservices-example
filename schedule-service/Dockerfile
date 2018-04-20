FROM openjdk:8-jdk-alpine
COPY ./ /home/
WORKDIR /home
RUN ./mvnw clean package   
ENTRYPOINT ["java","-jar","target/schedule-service.jar"]