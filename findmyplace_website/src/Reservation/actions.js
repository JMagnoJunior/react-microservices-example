
import axios from "axios"


var instance = axios.create({
    baseURL:  process.env.REACT_APP_ACCOMMODATION_SERVICE_URI ,
    auth: {
        username: 'user1',
        password: '123'
    },
    
  });

export function confirmReserve({reservation, uri_reserve}){
    
    return dispatch => 
    instance.post(uri_reserve.href, JSON.stringify(reservation), {
        headers: { 'Content-Type': 'application/json' }
    }
 ).then(response => dispatch({
        type: "RESERVE",
        data:{"reservation": response.data}
    })).catch(e => { dispatch( {
        type: "RESERVE_FAIL",
        data: {"error": "Sorry. The operations was refused. Maybe the selected period is not available anymore"}
    })
    } )
}