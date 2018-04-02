package com.magnojr.mservice.schedule.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.schedule.ScheduleServiceApplication;

@Service
public class ReservationMessageListener {

    
//    @RabbitListener(queues = ScheduleServiceApplication.QUEUE_GENERIC_NAME)
//    public void receiveMessage(final Message message) {
//    	System.out.println(message.toString());
//    }

    @RabbitListener(queues = ScheduleServiceApplication.QUEUE_SPECIFIC_NAME_RESERVATION)
    public void receiveMessage(final ReservationMessage reservationMessage) {
        System.out.println(reservationMessage.toString());
    }
}