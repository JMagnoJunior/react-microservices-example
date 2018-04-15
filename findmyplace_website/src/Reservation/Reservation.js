import React, { Component } from "react"; 
import Calendar from 'react-calendar'
import ReservationDetails from "./ReservationDetails"
import store from "./../store"


export default class  Reservation extends Component{
    
    constructor(){
        super();
        this.state = { 
            guest: "",
            passport: "",
            totalPrice : 0 ,
            start: new Date(),
            end: new Date(),
            showCalendar: true,
            reserved: false,
            error: false,
            message: "",

         } 

    }

    handleGuestInput = (e) => {
        this.setState({guest: e.target.value});                
    }

    handlePassportInput = (e) => {
        this.setState({passport: e.target.value});   
    }

    handleReservation = (dispatch, confirmReserve) => {     
           
        let reservation = {
            "guest" : {
                "name" : this.state.guest,
                "passport" : this.state.passport
            },
            "periodReserved": {
                "begin" : this.state.start.toISOString().substr(0,10),
                "end" : this.state.end.toISOString().substr(0,10)
            }
        }

        dispatch(confirmReserve({ "reservation": reservation, "uri_reserve": this.props.value._links.reserve} )).then(() =>{            
            this.setState({ reserved: true})
        })
                
    }

    disableDates = ({date, view }) => {
        let dates = this.props.value.schedules.map((s) =>  {              
            if (s.avaliable){     
                return new  Date(s.date)
            }
            else{
                return null
            }
        } ).filter((d) => d != null );
            var index = dates.findIndex(function(d) {             
            return d.toUTCString().valueOf().substr(0, 16) === date.toUTCString().valueOf().substr(0, 16); 
        });

        return index === -1
    }

    selectDate = (dates) => {
        let schedules = this.props.value.schedules;
        let priceForDatesSelected = schedules.map( (s) => {             
            let d = new Date(s.date)
            d.setHours(0, 0, 0, 0)  
            dates[0].setHours(0, 0, 0, 0)  
            dates[1].setHours(0, 0, 0, 0)  
            if( +d >= +dates[0] &&  +d <= +dates[1] ){                
                return s.price
            }else{
                return 0;
            }
        } ).reduce((prev, cur) => {            
            return prev + cur
        })
       this.setState({totalPrice: priceForDatesSelected, start: dates[0], end: dates[1], showCalendar: false})
    }

    changeDate = () => {
        this.setState({ showCalendar: true})
    }

    render = () => {
        let dateSelector = null; 
        let reserveDetails = null;                
        let showDetails = null; 
       
        if( this.state.showCalendar){
            dateSelector = <Calendar onChange={ this.selectDate } tileDisabled={this.disableDates}  returnValue="range" selectRange={true} />
        }
        else{
            dateSelector = <button onClick={ this.changeDate } className="btn btn-success" > From: {this.state.start.toISOString().substring(0, 10)}, To: {this.state.end.toISOString().substring(0, 10)}</button>
        }
        if( !this.state.showCalendar){
            reserveDetails = ( 
                    <ReservationDetails guest={this.state.guest} handleGuestInput={this.handleGuestInput} handlePassportInput={this.handlePassportInput} passport={this.state.passport} totalPrice={this.state.totalPrice} reserve={this.handleReservation} /> 
                )
        }
        
        if( !this.state.reserved ){
            showDetails = (
                <div className="row">
                    <div className="col">
                    { dateSelector }
                    </div>
                    <div className="col">
                        { reserveDetails }
                    </div>
                </div>
                )
        } else{
            showDetails = <div className="alert alert-success"> Thank you! A confirmation will be sent to your email</div>
        }

        return(
            <div>
            {showDetails}
            </div>
        )
    }
}

