import { createStore, applyMiddleware } from "redux"
const { List } = require('immutable')

const initialState = {
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



function reducer(state = initialState, action){    
    switch (action.type){    
        case "RESERVE": return state;
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



