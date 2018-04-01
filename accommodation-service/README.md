# Accommodation Service

### Introduction
If you need to find a accommodation, to take a look in its prices or locations, then here is the right place.

Here some mains functions presented by this component:
accommodation resource:
 * **GET  /accommodations**  -> list all accommodation (with pagination)
 * **GET /accommodations/{id}**  ->  get the accomodation with id {id}
 * **GET /accommodations/{id}/schedule** -> check the schedule for this accommodation
 * **GET /accommodations/search/findByNameContainingIgnoreCase{?name}** -> find accommodation by name
 * **GET /accommodations/{id}/checkavailability/from/{start}/to/{end}** -> check availability in a accommodation for a given period.
 
schedule resource:
 * **GET /schedules/search/findByDateBetweenAndAccommodationId{?start,end,accommodation_id}** -> list the schedule in a accommodation for a period
 
... you can check the possibilities accessing the url: **/accommodations/search** or **/schedules/search**
 
It is possible to create, update or delete a resource in a restfull way: 
* if you want to create a new accommodation just POST /accommodations
* if you want to create a new schedule just POST /schedules
* if you want to put this schedulle in some accommodation just PUT /schedules/{id}/accommodations with the payload as a URI of the desired accommodation resource /accommodation/{id} and Content-type=text/uri-list (like this: http://www.baeldung.com/spring-data-rest-relationships)
 
 
### Technical Informations 
  
Spring boot is really impressive. I was able to build many useful functionality using only two **@RepositoryRestResource** and one **@Controller**.
 
It has some secure layer implementend as example. To access any service you will have to use a Basic Auth.

The AccommodationService has a method checkAvailabilityAndPrice . It will be used by /reserve service to check if some reservation is possible and how much it will cost. The other services will be used direct by the front-end.


It is not completed yet. I have to put things like validation, exception handlers and swagger doc
