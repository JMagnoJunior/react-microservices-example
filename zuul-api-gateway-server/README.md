# API Gateway

A api gateway works as a "interceptor" for my services. 
Every external call for a service should go through this gateway before reach its destination.

In this project I am using this API gateway to include some security layer between the external world and the microservices.
In addition, this gateway is logging every request just as a filter example.
