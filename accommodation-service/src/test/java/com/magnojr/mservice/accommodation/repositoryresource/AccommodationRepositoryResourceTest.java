package com.magnojr.mservice.accommodation.repositoryresource;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.magnojr.mservice.accommodation.JpaDataConfiguration;
import com.magnojr.mservice.accommodation.configuration.TestJpaConfiguration;
import com.magnojr.mservice.accommodation.configuration.TestRestConfiguration;
import com.magnojr.mservice.accommodation.processor.AccommodationResourceProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { AccommodationResourceProcessor.class, JpaDataConfiguration.class,
		TestJpaConfiguration.class, TestRestConfiguration.class })
public class AccommodationRepositoryResourceTest {

	@Value("${schedule.resource.url}")
	private String scheduleUrl;

	@Value("${reservation.resource.url}")
	private String reservationUrl;

	@Value("${reserve.accommodation.path}")
	private String reserveAccommodationPath;

	@Value("${search.accommodation.path}")
	private String searchAccommodationPath;

	@Autowired
	AccommodationRepositoryResource resource;

	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldListAllAccommodations() throws Exception {

		mvc.perform(get("http://localhost:8080/accommodations").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void shouldGetAccommodationsById() throws Exception {

		String ID_ACCOMMODATION = "1";

		mvc.perform(
				get("http://localhost:8080/accommodations/" + ID_ACCOMMODATION).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void shouldHaveLinkForReservation() throws Exception {

		String ID_ACCOMMODATION = "1";

		mvc.perform(
				get("http://localhost:8080/accommodations/" + ID_ACCOMMODATION).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$._links.reserve.href",
						is(reservationUrl + reserveAccommodationPath + ID_ACCOMMODATION)));

	}

	@Test
	public void shouldHaveLinkToSearchForSchedules() throws Exception {

		String ID_ACCOMMODATION = "1";
		mvc.perform(
				get("http://localhost:8080/accommodations/" + ID_ACCOMMODATION).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$._links.schedules.href",
						is(scheduleUrl + searchAccommodationPath + ID_ACCOMMODATION)));

	}

}
