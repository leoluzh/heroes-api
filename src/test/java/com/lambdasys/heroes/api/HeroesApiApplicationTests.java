package com.lambdasys.heroes.api;

import com.lambdasys.heroes.api.constants.HeroesConstants;
import com.lambdasys.heroes.api.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebTestClientAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	void getOneHeroesById(){

		webTestClient.get()
				.uri(HeroesConstants.HEROES_ENDPOINT.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk()
				.expectBody();

	}

	@Test
	void getOneHeroeNotFound(){

		webTestClient.get()
				.uri(HeroesConstants.HEROES_ENDPOINT.concat("/{id}"),"9999")
				.exchange()
				.expectStatus().isNotFound();

	}

	@Test
	void deleteExistingHero(){

		webTestClient.get()
				.uri(HeroesConstants.HEROES_ENDPOINT.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk();

	}

	@Test
	void deleteNotExistingHero(){

		webTestClient.get()
				.uri(HeroesConstants.HEROES_ENDPOINT.concat("/{id}"),"9999")
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}


}
