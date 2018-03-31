
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
