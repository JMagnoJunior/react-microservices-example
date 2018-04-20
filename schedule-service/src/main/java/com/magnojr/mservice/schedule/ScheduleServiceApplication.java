package com.magnojr.mservice.schedule;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableRabbit
@EnableAutoConfiguration
public class ScheduleServiceApplication implements RabbitListenerConfigurer {

	@Value("${exchange.name}")
	private String exchangeName;
	@Value("${queue.schedule}")
	private String queueSchedule;
	@Value("${queue.reservation}")
	private String queueReservation;
	@Value("${routing.key}")
	private String routingKey;

	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(exchangeName);
	}

	@Bean
	public Queue appQueueSchedule() {
		return new Queue(queueSchedule);
	}

	@Bean
	public Queue appQueueReservation() {
		return new Queue(queueReservation);
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueSchedule()).to(appExchange()).with(routingKey);
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//	    ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
//
//	    Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//
//	    return converter;
		return new Jackson2JsonMessageConverter();
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

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ScheduleServiceApplication.class, args);
	}
}
