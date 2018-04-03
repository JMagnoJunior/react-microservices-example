package com.magnojr.mservice.reservation.queue;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.ReservationApplication;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.repository.ReservationRepository;

@Service
public class ReservationMessageListener {

	@Autowired
	ReservationRepository repository;

	@RabbitListener(queues = ReservationApplication.QUEUE_SCHEDULE)
	public void receiveMessage(RegisterScheduleMessage message) {
		if(message.getSuccess()){
			Optional<Reservation> r = repository.findById(message.getReservationId());
			if (r.isPresent() ){
				Reservation reservation = r.get();
				reservation.confirm();
				repository.save(reservation);
			}else{
				Reservation reservation = r.get();
				reservation.cancel();
				repository.save(reservation);
			}
			
		}
		
	}
}