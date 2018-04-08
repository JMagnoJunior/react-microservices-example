package com.magnojr.mservice.schedule.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMessageSender {
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Value("${routing.key}")
	private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ScheduleMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

	public void sendMessage(RegisterScheduleMessage message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}
}
