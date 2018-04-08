# Config Server

### Introduction
Sometimes in a microservice archtecture is a good idea to centralize the service's configuration in one place.
That is why we use a configuration server. In this case the configurations can be found in: 
https://github.com/JMagnoJunior/microservices-config

### Bus
What if there are many instance of the same service running at the same time and we have to notify every instance about some change on the configuration file? 
That is why I need a bus. 
Spring Config auto config a bus service to notify the services about some change in the configuration(It is not so simple. We need actuators too).
In this case the server config is using a rabbitmq (amqp protocol) to send this messages.

### Profiles
We can set a profile for a service on the 
bootstrap.properties (spring.profile.active) and using creating new files in the configuration repository. 
(Eg. If I want a accommodation config for dev environment I should create a file called accommodation-service-dev.properties)

