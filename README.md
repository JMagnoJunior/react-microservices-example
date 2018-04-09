# react-microservices-example

### Introduction
In this project I will try to show some concepts and techonologies related to microservices. This is a example of a booking website with a react app,  spring boot and NodeJs services.
My main motivation for this project is to have something in my portifolio to show to anyone interested in my job. Furthermore, I think it can be usefull for anyone interested in exchange some knoledge about microservice archtecture. I will try to show how to build a website based on microservices but let me know if you find something to improve in this code.

My free time is scarce then I will try to improve this project a litle at a time. I hope to complete this endeavor sometime in the future but for now I am trying to optimize my time. My mission is just to show how a fancy microservice enviroment looks like and to present some tools and features that can be useful to build this environment.

This project should run inside a docker.


### Overview
Here is how this project is organized:
* /react-microservices-example
  * /accommodation-service     -> sprin boot service related to accommodation process. It show some basics (but nice) features of spring boot. A example of swagger can be found here;
  * /file-service              -> utility service to handle images and files;
  * /findmyplace_website       -> A website written in react to consume the other services;
  * /reservation-service       -> spring boot service related to reserve process to show a case of eventual consistency. It will be used to make a reservation and inform the schedule about that event;
  * /schedule-service          -> spring boot service related to schedule that will work together with the reservation service;
  * /findmyplace-config-server -> This is a centralized config server for my services;
  * /zuul-api-gateway-server   -> This is the api gateway. For now it has a basic security layer (for a real scenario would be better something a bit sophisticated) and it generates a simple access log as example; 
  * docker-compose.yml         -> Docker config for a dev enviroment;
        
    
### Where do I start?
I would recommend to take a look into the /accommodation-service first, but every project/service has his own README.md file.
I will use it to describe every service and its features.

### How to install it?
This project will run inside a docker.

inside the /react-microservices-example folder:
$ docker-compose up --build

( Sorry, but this process will take a loooooo...ooonng time but with some luck you will be able to run it without errors.
I do not really recommend to install all this project for now. It will spend a lot of time and the only visible interface will be a simple accommodation search written in react.)


### References

* https://12factor.net
* https://www.martinfowler.com/microservices
