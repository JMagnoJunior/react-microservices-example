
import axios from "axios"

var instance = axios.create({
    baseURL:  process.env.REACT_APP_ACCOMMODATION_SERVICE_URI ,
    auth: {
        username: 'user1',
        password: '123'
    },
    
  });
// export  function addAccommodation(accommodation){
//     return {
//         type: "ADD_ACCOMMODATION",
//         accommodation: accommodation
//     }
// }



export  function searchAccommodation({ search_name } ){ 
    return dispatch =>
    instance.get("accommodations/search/findByNameContainingIgnoreCase?name="+ search_name)
    .then(response => dispatch({
        type: "SEARCH_ACCOMMODATION" , 
        data:response.data._embedded} 
    ))
}

export function getScheduleAccommodation({uri_schedules}){
    return dispatch =>
    instance.get("http://localhost:8765/schedule-service/schedules/search/findByIdAccommodation?id_accommodation=1").then(response => dispatch({
        type: "GET_SCHEDULES",
        data:response.data._embedded
    }))
}