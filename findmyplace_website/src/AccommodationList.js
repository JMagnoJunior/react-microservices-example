import React from "react"; 
import Accommodation from "./Accommodation"

export default function AccommodationList(props){
    
    return(
        <div className="card">
        
            <div className="card-body">
                { props.accommodations.map((acom,k) => <Accommodation key={k} value={acom} />) }
            </div>
        </div>
    )
}

