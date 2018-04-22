package com.magnojr.mservice.reservation.queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.magnojr.mservice.reservation.model.Guest;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.model.StatusReservation;
import com.magnojr.mservice.reservation.repositoryresource.ReservationRepository;

@RunWith(SpringRunner.class)
public class ReservationMessageListenerTest {

	private long RESERVATION_ID = 1L;

	@Autowired
	ReservationMessageListener reservationMessageListener;

	@MockBean
	ReservationRepository repository;

	@TestConfiguration
	static class ReservationServiceImplTestContextConfiguration {

		@Bean
		public ReservationMessageListener ReservationMessageListener() {
			return new ReservationMessageListener();
		}
	}

	Reservation r = null;

	@Before
	public void setUp() {
		r = new Reservation(new Guest(), new PeriodReserved(), 1L, new BigDecimal("100"));
		Mockito.when(repository.findById(RESERVATION_ID)).thenReturn(Optional.of(r));

	}

	@Test
	public void whenReceiveAMessageConfirmationAndItIsValid_ShouldChangeStatusToConfirmed() {

		RegisterScheduleMessage message = new RegisterScheduleMessage(RESERVATION_ID, true);
		reservationMessageListener.receiveMessage(message);

		assertThat(r.getStatus(), equalTo(StatusReservation.CONFIRMED));

	}

	@Test
	public void whenReceiveAMessageConfirmationAndItIsInvalid_ShouldChangeStatusToCancelled() {

		RegisterScheduleMessage message = new RegisterScheduleMessage(RESERVATION_ID, false);
		reservationMessageListener.receiveMessage(message);

		assertThat(r.getStatus(), equalTo(StatusReservation.CANCELLED));

	}

}
