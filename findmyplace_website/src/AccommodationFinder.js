import React, { Component, Fragment } from 'react';
import { withLayout } from "./Layout"
import  SearchPanel   from "./SearchPanel"
import AccommodationList from "./AccommodationList"
import { Provider } from "react-redux";
import store from "./store"
import {searchAccommodation} from "./actions"

class AccommodationFinder extends Component {
    constructor(){
        super();
        this.state = { search_name : "",  show_details: false, ...store.getState()} 
    }

    componentWillMount() {
        store.dispatch(searchAccommodation({search_name : this.state.search_name })). then(() => {
            if(this.state != store.getState()){
                this.setState({...store.getState()} )
            }                        
        })

    
    }

    componentWillUnmount() {
     
    }

    handleSearchChange = (e) => {
        
        this.setState({search_name: e.target.value});        
        
    }

    handleClickSearch = (dispatch, searchAccommodation) => {
        
        dispatch(searchAccommodation({search_name : this.state.search_name })). then(() => {
            this.setState({...store.getState()} )
        })
        
    }

    handleClickDetails = (dispatch,uri_schedules, getScheduleAccommodation) => {
        
        dispatch(getScheduleAccommodation({uri_schedules : uri_schedules})).then( ()=> {
            this.setState({show_details: true, ...store.getState()})
        })
        
    }

    render = () =>  {
      return (
          <div>
         <Provider store={store}>
         
         <Fragment>                
            <SearchPanel search_name={this.state.search_name} 
                        handle_search_name={this.handleSearchChange} 
                        handle_click_search={this.handleClickSearch} />
            <AccommodationList accommodations={this.state.accommodations} show_details={this.state.show_details} handle_click_details={this.handleClickDetails} />
        </Fragment>
         </Provider>
        </div>
      );
    }
}

export default withLayout()(AccommodationFinder);


