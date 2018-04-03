package com.magnojr.mservice.reservation.service;

import java.text.SimpleDateFormat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.bean.AvailabilityAndPrice;
import com.magnojr.mservice.reservation.clients.ScheduleServiceProxy;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.queue.ReservationMessageSender;
import com.magnojr.mservice.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ScheduleServiceProxy accommodationService;

	@Autowired
	private ReservationRepository repository;
	
	@Autowired
	private  RabbitTemplate rabbitTemplate;

	@Autowired
	ReservationMessageSender messageSender;


	public Reservation reserve(Reservation reservation)  {
		Reservation result = null;
		PeriodReserved period = reservation.getPeriodReserved();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		AvailabilityAndPrice verification = accommodationService.checkAvailability(reservation.getAccommodation_id(),
				df.format(period.getBegin()), df.format(period.getEnd()));
		
		if (verification.isAvailable()) {			
			reservation.setTotalPrice(verification.getPrice());			
			reservation.waitingConfirmation();
			result = repository.save(reservation);
			// send reservation to queue to informe schedule about this reserve
			messageSender.sendMessage(result);
		} else {
			// TODO: Throw exception
			System.out.println("just a test");
		}

		return result;
	}
}
