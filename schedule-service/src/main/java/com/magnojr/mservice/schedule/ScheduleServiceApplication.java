package com.magnojr.mservice.schedule;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@SpringBootApplication
@EnableRabbit
public class ScheduleServiceApplication implements RabbitListenerConfigurer {

	public static  String EXCHANGE_NAME = "findmyplace-exchange";

//	public  static final String QUEUE_GENERIC_NAME = "findmyplace";
	public static final String QUEUE_SPECIFIC_NAME_SCHEDULE = "findmyplace-schedule";
	public static final String QUEUE_SPECIFIC_NAME_RESERVATION = "findmyplace-reservation";
	public  static final  String ROUTING_KEY = "reservation.confirm";

	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

//	@Bean
//	public Queue appQueueGeneric() {
//		return new Queue(QUEUE_GENERIC_NAME);
//	}

	@Bean
	public Queue appQueueSpecific() {
		return new Queue(QUEUE_SPECIFIC_NAME_SCHEDULE);
	}
//	
	@Bean
	public Queue appQueueReservationSpecific() {
		return new Queue(QUEUE_SPECIFIC_NAME_RESERVATION);
	}

//	@Bean
//	public Binding declareBindingGeneric() {
//		return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY);
//	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(ROUTING_KEY);
	}
	
	

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(ScheduleServiceApplication.class, args);
	}
}
