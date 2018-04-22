package com.magnojr.mservice.reservation.queue;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.repositoryresource.ReservationRepository;

@Service
public class ReservationMessageListener {

	@Autowired
	private ReservationRepository repository;

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