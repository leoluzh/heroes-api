package com.lambdasys.mangas.api;

import com.lambdasys.mangas.api.constants.MangasConstants;
import com.lambdasys.mangas.api.repository.MangasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class MangasApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	MangasRepository heroesRepository;

	@Test
	void getOneHeroesById(){

		webTestClient.get()
				.uri(MangasConstants.MANGAS_ENDPOINT.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk()
				.expectBody();

	}

	@Test
	void getOneHeroeNotFound(){

		webTestClient.get()
				.uri(MangasConstants.MANGAS_ENDPOINT.concat("/{id}"),"9999")
				.exchange()
				.expectStatus().isNotFound();

	}

	@Test
	void deleteExistingHero(){

		webTestClient.get()
				.uri(MangasConstants.MANGAS_ENDPOINT.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk();

	}

	@Test
	void deleteNotExistingHero(){

		webTestClient.get()
				.uri(MangasConstants.MANGAS_ENDPOINT.concat("/{id}"),"9999")
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}


}
