package com.magnojr.mservice.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("system", "123");
	}
	
//	@Bean
//	public FeignFormatterRegistrar localDateFeignFormatterRegistrar() {
//	    return new FeignFormatterRegistrar() {
//	        @Override
//	        public void registerFormatters(FormatterRegistry formatterRegistry) {
//	            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
//	            registrar.setUseIsoFormat(true);	           
//	            registrar.registerFormatters(formatterRegistry);
//	        }
//	    };
//	}
}
