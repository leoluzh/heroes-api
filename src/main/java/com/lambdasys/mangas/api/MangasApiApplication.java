package com.lambdasys.mangas.api;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class MangasApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(MangasApiApplication.class, args);
	}

}
