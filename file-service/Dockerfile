FROM openjdk:8-jdk
COPY ./ /home/
WORKDIR /home
RUN ./mvnw clean package       
ENTRYPOINT ["java","-jar","target/file-service.jar"]