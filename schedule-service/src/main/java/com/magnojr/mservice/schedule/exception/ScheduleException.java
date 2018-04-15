package com.magnojr.mservice.schedule.exception;

@SuppressWarnings("serial")
public class ScheduleException extends RuntimeException{
	public ScheduleException(){
		super();
	}

	public ScheduleException(String string) {
		super(string);
	}
}
