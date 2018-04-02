package com.magnojr.mservice.reservation.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.ReservationApplication;
import com.magnojr.mservice.reservation.model.Reservation;

@Service
public class ReservationMessageSender {


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ReservationMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


	public void sendMessage(Reservation reservation) {
		final ReservationMessage message = new ReservationMessage(reservation);
		rabbitTemplate.convertAndSend(ReservationApplication.EXCHANGE_NAME, ReservationApplication.ROUTING_KEY, message);
	}
}
