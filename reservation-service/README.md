# Reservation service

We can use this service to reserve a accommodation. It will use the accommodation service to check prices and availability and if it is all ok this service will reserve the accommodation in a period selected. 

This service is not completed yet. It will have to inform the accommodation service about the reservation event. For that it will use some "distributed transaction" strategy. Being more specific, It will not be a distributed transaction but a eventual consistency using kafka or rabbitmq.


Maybe someone would consider this separation too fine and eventually this thought would be right, but there are two main reason for this decision. First, I want to show how a microservice can interact with others. Second, I think that even in a real world scenario to split accommodation service and reservation service would help us keep both the "reservation area" and the "search for accommodation area" in a website or mobile app running and scaling isolated.

In the future I will use this service to talk about transactions. For now, here what I think it is a good reference: http://www.baeldung.com/transactions-across-microservices
