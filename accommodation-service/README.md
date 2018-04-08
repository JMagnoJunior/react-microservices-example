# Accommodation Service

### Introduction
In this section I will present some basic concepts of a rest service.

### About the service
If you need to find a accommodationthen here is the right place.

Here some mains functions presented by this component:
accommodation resource:
 * **GET  /accommodations**  -> list all accommodation (with pagination)
 * **GET /accommodations/{id}**  ->  get the accomodation with id {id}
 * **GET /accommodations/{id}/schedule** -> check the schedule for this accommodation
 * **GET /accommodations/search/findByNameContainingIgnoreCase{?name}** -> find accommodation by name
 * **GET /accommodations/{id}/checkavailability/from/{start}/to/{end}** -> check availability in a accommodation for a given period.
 
 You can check the possibilities accessing the url: **/accommodations/search** 
 
It is possible to create, update or delete this resource in a restfull way: 
* if you want to create a new accommodation just POST /accommodations
* if you want to update a existent accommodation just PUT /accommodations
* if you want to delete a existent accommodation just DELETE /accommodations

It worths to mention that the schedule informations for a accommodation can be found in another service, but there is a strong relation between them. That is how to create a schedule for a accommodation:
* 1 - Create your accommodation with POST /accommodations/
* 2 - Create a new schedule with POST /schedules
* 3 - Update the schedule in the accommodation with PUT /schedules/{id}/accommodations where the payload is a URI of the desired accommodation resource (eg. /accommodation/{id}) and the Content-type=text/uri-list (link details: http://www.baeldung.com/spring-data-rest-relationships)
 
You could check everything in the swagger-ui application embedded in this service on a standalone version, but it won't be visible if you use my docker-compose file. I hid the services behind a gateway =)
 
### Features and Comments
* Spring boot is really impressive. Just one **@RepositoryRestResource** was enough to build this service.
* It was added a new method for the RepositorRestResource called findByNameContainingIgnoreCase with some annotations for swagger.
* The Accommodation returned by the RepositorRestResource is incomplete and that's why I had to add a AccommodationResourceProcessor. To keep the things HATEOAS I added a link to all the schedules of some accommodation. 
* Accommodation class shows a simple validations - The name has to have at least two characters
* RestConfiguration is a good way to customize the RepositoryRestResource. In this case the pagination will have max size = 15
* Every exception in this service will be receive the same treatment. It will return a custom ExceptionResponse.
* This service relies on a centralized configuration service.
* There are many other things enable in this project that is not visible at a first glance. Things like actuators that can show us usefull informations for a microservice environment like  health, info, metrics and so on.  It is possible to customize health, but I think it is not necessary for this scenario.

