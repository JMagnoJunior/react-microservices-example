package com.magnojr.mservice.reservation.service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.bean.ReservationIntent;
import com.magnojr.mservice.reservation.clients.ScheduleServiceProxy;
import com.magnojr.mservice.reservation.exception.ReservationException;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.queue.RegisterScheduleMessage;
import com.magnojr.mservice.reservation.queue.ReservationMessageSender;
import com.magnojr.mservice.reservation.repositoryresource.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ScheduleServiceProxy scheduleService;

	@Autowired
	private ReservationRepository repository;

	@Autowired
	private ReservationMessageSender messageSender;

	@Autowired
	public ReservationService(ScheduleServiceProxy scheduleService, ReservationRepository repository,
			ReservationMessageSender messageSender) {
		super();
		this.scheduleService = scheduleService;
		this.repository = repository;
		this.messageSender = messageSender;
	}

	public ReservationService() {
		super();
	}

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
	
	@RabbitListener(queues = "${queue.schedule}")
	public void receiveMessage(RegisterScheduleMessage message) {

		Optional<Reservation> r = repository.findById(message.getReservationId());
		if (r.isPresent()) {
			if (message.getSuccess()) {
				Reservation reservation = r.get();
				reservation.confirm();
				repository.save(reservation);
			} else {
				cancel(r);
			}
		} else {
			cancel(r);
		}

	}

	private void cancel(Optional<Reservation> r) {
		Reservation reservation = r.get();
		reservation.cancel();
		repository.save(reservation);
	}
}
