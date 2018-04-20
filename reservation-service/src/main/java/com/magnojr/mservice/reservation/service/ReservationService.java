package com.magnojr.mservice.reservation.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.bean.ReservationIntent;
import com.magnojr.mservice.reservation.clients.ScheduleServiceProxy;
import com.magnojr.mservice.reservation.exception.ReservationException;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.queue.ReservationMessageSender;
import com.magnojr.mservice.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ScheduleServiceProxy scheduleService;

	@Autowired
	private ReservationRepository repository;

	@Autowired
	ReservationMessageSender messageSender;

	public Reservation reserve(Reservation reservation, Long accommodationId) {
		Reservation result = null;

		PeriodReserved period = reservation.getPeriodReserved();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ReservationIntent reservationIntent = scheduleService.checkAvailability(accommodationId,
				period.getBegin().format(formatter), period.getEnd().format(formatter));

		if (reservationIntent.isAvailable()) {

			reservation.setTotalPrice(reservationIntent.getPrice());
			reservation.waitingConfirmation();
			result = repository.save(reservation);
			// send reservation to queue to informe schedule about this reserve
			messageSender.sendMessage(result, accommodationId);

		} else {
			throw new ReservationException();
		}
		return result;
	}
}
