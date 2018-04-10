import React from "react"; 
import AccommodationDetails from "./AccommodationDetails"
import { connect } from "react-redux"
import {getScheduleAccommodation} from "./actions"

export  function Accommodation(props){
    var  element = <button type="button" onClick={props.getSchedule} className="btn btn-primary"> Details </button>
    if(props.show_details){
        element = <AccommodationDetails  value={props.value} />
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
        getSchedule: () =>  props.handle_click_details(dispatch, props.value._links.schedules, getScheduleAccommodation)
    })
)(Accommodation);
