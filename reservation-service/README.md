# Reservation service

What a transaction in a microservice environment looks like? For most case the answer is: It does not exists. 
Of course, it is possible to apply a real transaction in a distributed system but there is a high cost. 
The two phase commit, probably, is the most famous strategy for transaction in a distributed system but many times we can adopte a better and cheaper strategy. I am talking about eventual consistency and compensating transaction pattern.

To reserve a accommodation we need to know if that accommodation is available. We can check that in the schedule of the accommodation. We have two services here that should works together. After register a reserve we would like to update the accommodation's schedule to unavailable. It is very important to not reserve a accommodation without update its schedule.  

The solution that I found for this case rely on rabbitmq to send a async message to the schedule after a new reserve. The reservation is created with the status WAITING.
When the schedule receives the reservation's message it updates its state to inform to anyone that this days are not available anymore. After that the schedule sends a message to the reservation service informing that the specified reservation is valid. Finally, the reservation service update its state to CONFIRMED.  

### @FeignClient

Another thing that I am using in this project is the Feing. Springboot has a easy solution to call rest service using RestTemplates but when we need to communicate with many services it can turn the things a bit messy. Feing help us to create a centralized service proxy to call the others rest services. 

### RabbitMq

This project has a simple  RabbitMq usage example. Take a look inside the queue package.

### Reference for eventual consistency
http://www.baeldung.com/transactions-across-microservices
https://stackoverflow.com/questions/30213456/transactions-across-rest-microservices
