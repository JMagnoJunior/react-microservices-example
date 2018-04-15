package com.magnojr.mservice.reservation.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.ReservationApplication;
import com.magnojr.mservice.reservation.model.Reservation;

@Service
public class ReservationMessageSender {

	@Value("${exchange.name}")
	private String exchangeName;
	
	@Value("${routing.key}")
	private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ReservationMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

	public void sendMessage(Reservation reservation, Long accommodationid) {
		final ReservationMessage message = new ReservationMessage(reservation, accommodationid);
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}
}
