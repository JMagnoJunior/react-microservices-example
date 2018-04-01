//package com.magnojr.mservice.accommodation.model;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//
//import com.magnojr.mservice.schedule.model.AvailabilityAndPrice;
//import com.magnojr.mservice.schedule.model.DateAvailability;
//
//public class AvailabilityAndPriceTest {
//	
//	@Test
//	public void shouldCost400AndBeAvailableWhenTwoDaysAvailableCosts200() throws ParseException  {
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = df.parse("2018-04-01");
//		Date date2 = df.parse("2018-04-03");
//		Boolean available = true;
//		Accommodation a1 = new Accommodation();
//		List<DateAvailability> list = new ArrayList<>();
//		DateAvailability da1 = new DateAvailability(date1,available,a1,new BigDecimal("200"));
//		DateAvailability da2 = new DateAvailability(date2,available,a1,new BigDecimal("200"));
//		list.add(da1);
//		list.add(da2);
//		
//		AvailabilityAndPrice ap = new AvailabilityAndPrice();
//		ap.addDatesInformed(list);
//		
//		assertThat(ap.getPrice(), equalTo(new BigDecimal("400")));
//		assertThat(ap.isAvailable(), equalTo(true));
//		
//	}
//	
//	@Test
//	public void shouldBeUnavailableIfAnydateInformeIsUnavailable() throws ParseException  {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = df.parse("2018-04-01");
//		Date date2 = df.parse("2018-04-03");
//		Boolean available = true;
//		Boolean unavailable = false;
//		Accommodation a1 = new Accommodation();
//		List<DateAvailability> list = new ArrayList<>();
//		DateAvailability da1 = new DateAvailability(date1,available,a1,new BigDecimal("200"));
//		DateAvailability da2 = new DateAvailability(date2,unavailable,a1,new BigDecimal("200"));
//		list.add(da1);
//		list.add(da2);
//		
//		AvailabilityAndPrice ap = new AvailabilityAndPrice();
//		ap.addDatesInformed(list);
//				
//		assertThat(ap.isAvailable(), equalTo(false));
//	}
//}
