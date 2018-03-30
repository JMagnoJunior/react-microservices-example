package com.magnojr.mservice.accommodation.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.magnojr.mservice.accommodation.AccommodationApplication;
import com.magnojr.mservice.accommodation.MyBasicAuthenticationEntryPoint;
import com.magnojr.mservice.accommodation.SecurityConfiguration;
import com.magnojr.mservice.accommodation.model.AvailabilityAndPrice;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={AccommodationApplication.class, MyBasicAuthenticationEntryPoint.class, SecurityConfiguration.class})
@SpringBootTest
public class AccommodationControllerTests {

	@Autowired
	AccommodationController controller;
	
	@Test
	public void checkAvailabilityAndPrice() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date b = df.parse("2018-04-01");
		Date e = df.parse("2018-04-03");
		AvailabilityAndPrice result = controller.checkAvailabilityAndPrice(1L, b, e);
		assertThat(result.getPrice(),equalTo(new BigDecimal("300.00")) );		
		assertThat(result.isAvailable(), equalTo(false) );
	}

}
