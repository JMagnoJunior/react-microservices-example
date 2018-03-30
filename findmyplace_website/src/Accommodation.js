import React from "react"; 

export default function Accommodation(props){
    
    return(
        <div className="card mb-2 " >
            <b>Name:</b> { props.value.name }  <br />
            <b>Address:</b> {props.value.address.streetAddress} {props.value.address.city} - {props.value.address.state}
        </div>
    )
}

