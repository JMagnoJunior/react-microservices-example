package com.magnojr.mservice.reservation.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.magnojr.mservice.reservation.bean.ReservationIntent;
import com.magnojr.mservice.reservation.clients.ScheduleServiceProxy;
import com.magnojr.mservice.reservation.model.Guest;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.model.StatusReservation;
import com.magnojr.mservice.reservation.queue.ReservationMessageSender;
import com.magnojr.mservice.reservation.repositoryresource.ReservationRepository;

@RunWith(SpringRunner.class)
public class ReservationServiceTest {

	@MockBean
	private ReservationRepository repository;

	@MockBean
	private ScheduleServiceProxy scheduleService;

	@MockBean
	ReservationMessageSender messageSender;

	@Autowired
	ReservationService reservationService;

	long ACCOMMODATION_ID = 1L;
	String START_VALID_DATE = "2018-04-01";
	String END_VALID_DATE = "2018-04-03";

	@Before
	public void setUp() {

		ReservationIntent validIntent = new ReservationIntent(true, new BigDecimal("300"));
		Mockito.when(scheduleService.checkAvailability(ACCOMMODATION_ID, START_VALID_DATE, END_VALID_DATE))
				.thenReturn(validIntent);

	}

	@TestConfiguration
	static class ReservationServiceImplTestContextConfiguration {

		@Bean
		public ReservationService reservationService() {
			return new ReservationService();
		}
	}

	@Test
	public void whenReserve_shouldHaveStatusWaiting() {
		Guest guest = new Guest();
		LocalDate start = LocalDate.parse(START_VALID_DATE, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate end = LocalDate.parse(END_VALID_DATE, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		PeriodReserved periodReserved = new PeriodReserved(start, end);
		Reservation reservation = new Reservation(guest, periodReserved, 1L, new BigDecimal("100"));

		reservationService.reserve(reservation, 1L);
		
		assertThat(reservation.getStatus(), equalTo(StatusReservation.WAITING) );
	}

}
