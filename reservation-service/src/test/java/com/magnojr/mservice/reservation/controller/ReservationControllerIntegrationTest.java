package com.magnojr.mservice.reservation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.magnojr.mservice.reservation.JpaDataConfiguration;
import com.magnojr.mservice.reservation.configuration.TestJpaConfiguration;
import com.magnojr.mservice.reservation.configuration.TestRestConfiguration;
import com.magnojr.mservice.reservation.model.Guest;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.repositoryresource.ReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { JpaDataConfiguration.class, TestJpaConfiguration.class, TestRestConfiguration.class })
@DataJpaTest
public class ReservationControllerIntegrationTest {

	// @Autowired
	// ReservationRepository repository;
	//
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MockMvc mvc;

	@Autowired
	ReservationRepository resourceRepository;

	private long ID_ACCOMMODATION = 1L;

	@Test
	public void shouldListAllReservation() throws Exception {

		// given
		Reservation r1 = new Reservation(new Guest("Test", "111111"), new PeriodReserved(), ID_ACCOMMODATION,
				new BigDecimal(100));
		entityManager.persist(r1);
		entityManager.flush();

		mvc.perform(get("http://localhost:8080/reservations").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
