package com.magnojr.mservice.schedule.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.schedule.service.ScheduleService;

@Service
public class ScheduleMessageListener {

	
	@Autowired
	ScheduleService service;

	@RabbitListener(queues = "${queue.reservation}")
	public void receiveMessage(final ReservationMessage reservationMessage) {		
		service.reserveSchedule(reservationMessage.getAccommodationId(), reservationMessage.getBeginFormated(),
				reservationMessage.getEndFormated(), reservationMessage.getReservationId());
	}
}