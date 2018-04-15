import { createStore, applyMiddleware } from "redux"
const { List } = require('immutable')

const initialState = {
    api: {
        accommodations : [],
    },
    components: {
        accommodation: {

        },
        reservation: {
            guest: "",
            passport: "",
            totalPrice : 0 ,
            start: new Date(),
            end: new Date(),
            showCalendar: true,
            reserved: false,
            error: false,
            message: "",
        },
        
    }
}



function searchAccommodation(state, action){       
    if(action.data.accommodations != state.accommodations){
        return { ...state,  api : { ...state.api, accommodations: action.data.accommodations } }
    }else{
        return { ...state}
    }
    
}

function getScheduleAccommodation(state, action){
    
    var list = List(state.api.accommodations);    
    var accommodations = list.update(
        list.findIndex((item) => { 
            return JSON.stringify(item) === JSON.stringify(action.data.accommodation)    
        }), 
        (item) => {
            item.schedules = action.data.schedule.schedule;
            item.show_details = true;
            return item
        }
    );        
    return Object.assign({}, state, {...state, api :{accommodations: accommodations.toArray()} } )
}

function reserve(){
    
}



function reducer(state = initialState, action){    
    switch (action.type){
        case "SEARCH_ACCOMMODATION": return searchAccommodation(state, action);
        case "GET_SCHEDULES": return getScheduleAccommodation(state, action);
        case "RESERVE": return reserve(state, action);
        default: return state;
    }
}

const logger = store => next => action =>  {
    console.log("==========")
    console.log(action)
    console.log("current state: ")
    console.log(store.getState())
    
    const result = next(action)
    console.log("next state: ")
    console.log(store.getState())
    console.log("==========")
    
}

const async = store => next => action =>  {
    if (typeof action === "function"){
        console.log("called as a function!")
        return action(store.dispatch)
    }

    return next (action)
}

export default  createStore(reducer, applyMiddleware(async, logger));



