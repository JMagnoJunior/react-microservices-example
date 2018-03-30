import React from 'react';
import { connect } from "react-redux"
import {searchAccommodation} from "./actions"


export function SearchPanel(props){

    return(
        <div className="row">
            <div className="col">      
                <div className="form-inline" >
                    
                    <div className="form-group">
                        <input type="text" onKeyPress={props.add} value={props.search_name} onChange={props.handle_search_name} />            
                    </div>          

                    <a onClick={props.add} className="ml-1 form-group btn btn-info"  >Search</a>
                </div>
            </div>        
        </div>
    )
}

 export default connect(
    state => state,
    (dispatch, props) => ({
        add: () =>  props.handle_click_search(dispatch, searchAccommodation)
    })
)(SearchPanel);