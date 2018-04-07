FROM openjdk:8-jdk-alpine
COPY ./ /home/
WORKDIR /home
RUN ./mvnw clean package   
RUN ls -a
RUN ls target/    
ENTRYPOINT ["java","-jar","target/accommodation-service.jar"]