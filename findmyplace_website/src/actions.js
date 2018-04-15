
import axios from "axios"

var instance = axios.create({
    baseURL:  process.env.REACT_APP_ACCOMMODATION_SERVICE_URI ,
    auth: {
        username: 'user1',
        password: '123'
    },
    
  });

export  function searchAccommodation({ search_name } ){ 
    return dispatch =>
    instance.get("accommodations/search/findByNameContainingIgnoreCase?name="+ search_name)
    .then(response => dispatch({
        type: "SEARCH_ACCOMMODATION" , 
        data:response.data._embedded} 
    ))
}

export function getScheduleAccommodation({accommodation, uri_schedules}){
    return dispatch =>
    instance.get(uri_schedules.href).then(response => dispatch({
        type: "GET_SCHEDULES",
        data:{ "schedule":  response.data._embedded, "accommodation": accommodation }
    }))
}

export function confirmReserve({reservation, uri_reserve}){
    console.log(reservation)
    return dispatch => 
    instance.post(uri_reserve.href, JSON.stringify(reservation), {
        headers: { 'Content-Type': 'application/json' }
    }
 ).then(response => dispatch({
        type: "RESERVE",
        data:{"reservation": response.data}
    }))
}