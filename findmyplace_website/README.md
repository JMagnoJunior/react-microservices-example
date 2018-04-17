# Find My Place - React Website

# Introduction 

I do not consider myself as a really good front end programmer, but still I know something about ReactJs, Javascript and Functional Programming. My main goal is to simplify the front end task providing a sofisiticated solution on the backend.

This project shows how to interacts with my back end services. It uses redux and immutables and it is totally based on a functional programming.

### HATEOAS
I can siplify a lot my front end using spring boot and a HATEOAS based architecture for my API's. It worth to mention that I am not handling any id throughout my react components. Every new possible state for a particular resoure is provided by the resource itself. 
E.g. If I want to check the schedule for some accommodation all  I need to do is to verify the _link.schedules for that accommodation and I will receive all the information that I need. 


### Store
  There is only one store for the entire application. The state of each component and each api query are registered here.
  
```
let state = {
    api: { ... },
    components: {
        accommodation: {...},
        reservation: {...},
        ...
    }  
}
```
A action can be dispatched from any component to change the state of my application and I am using immutable.js to treat any changes on the store's state. That is a regular implementation of the flux pattern with Redux.


### High Order Components
Some components in this project, e.g. Accommodations.js, are high order components. That means, they are function components that will be used by another function and they will have some props redefined before to be rendered. 
The reason is that we need this components to dispatch some event that will update the store's state. Redux provide a connect function which is perfect to help us with it. We don't want to call the handler function received in props directly, but we want to provide the action and the dispatcher to this handler function. In this case a high order component can be used to redefine how this handler will be called by my component. 

Example: Accommodation.js
```
...
import {getScheduleAccommodation} from "./actions"

export  function Accommodation(props){
  var  element = <button type="button" onClick={props.getSchedule} className="btn btn-primary"> Details </button>    
  ...
}

export default connect(
    state => state,
    (dispatch, props) => ({
        getSchedule: () =>  props.handle_click_details(dispatch,props.value, getScheduleAccommodation)
    })
)(Accommodation);
```

(... not finished yet)
