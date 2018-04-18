import React from "react"; 
import Reservation from "./../Reservation/Reservation.js"
import { connect } from "react-redux"
import {getScheduleAccommodation} from "./actions"

export  function Accommodation(props){
    var  element = <button type="button" onClick={props.getSchedule} className="btn btn-primary"> Details </button>    
    if(props.value.show_details){
        element = <Reservation  value={props.value}  />
    }
    return(
        <div className="card mb-2 " >       
        <img src={ process.env.REACT_APP_IMAGE_SERVICE_URI + "/files/"+ props.value.image.uri } height="42" width="42" />
            <b>Name:</b> { props.value.name }  <br />
            <b>Address:</b> {props.value.address.streetAddress} {props.value.address.city} - {props.value.address.state}            
            {element}
        </div>
    )
}

export default connect(
    state => state,
    (dispatch, props) => ({
        getSchedule: () =>  props.handle_click_details(dispatch,props.value, getScheduleAccommodation)
    })
)(Accommodation);
