# Accommodation Service

### Introduction
If you need to find a accommodation, to take a look in its prices or locations, then here is the right place.

Here some mains functions presented by this component:
accommodation resource:
 * GET  /accommodations  -> list all accommodation (with pagination)
 * GET /accommodations/{id}  ->  get the accomodation with id {id}
 * GET /accommodations/{id}/schedule -> check the schedule for this accommodation
 * GET /accommodations/search/findByNameContainingIgnoreCase{?name} -> find accommodation by name
 * GET /accommodations/{id}/checkavailability/from/{start}/to/{end} -> check availability in a accommodation for a given period.
 
schedule resource:
 * GET /schedules/search/findByDateBetweenAndAccommodationId{?start,end,accommodation_id} -> list the schedule in a accommodation for a period
 
... you can check all the possibilities accessing the url: /accommodations/search or /schedules/search
 
 
### Technical Informations 
  
Spring boot is really impressive. I was able to build many useful functionality using only two @RepositoryRestResource and one @Controller.
 
 ... (not finished yet)

### What comes next?
 * I will create a new interface to search accommodation by name and period with date available to reserve.
 * It needs a swagger doc
 * Improve the process of resource creation. It has some secure already but a api gateway would be better.
