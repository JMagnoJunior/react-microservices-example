import React, {  Fragment } from "react"; 
import { connect } from "react-redux"
import {confirmReserve} from "./actions"

export function AccommodationReserveDetails(props){

    return (
        <Fragment >
            >
                        <span >Total Price:  { props.totalPrice } </span>
                        <br />
                        <label  > Guest: </label> <input onChange={props.handleGuestInput} value={props.guest}/>
                        <br />
                        <label > Passaport: </label> <input onChange={props.handlePassportInput} value={props.passport}/>
                        <br />
            
                        <button className="btn btn-primary" onClick={props.reserve} > Confirm </button>
        </Fragment>
    )
}

export default connect(
    state => state,
    (dispatch, props) => ({
        reserve: () =>  props.reserve(dispatch, confirmReserve)
    })
)(AccommodationReserveDetails);
