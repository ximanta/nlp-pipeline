package com.stackroute.lemmatizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This microservice aims to lemmatize the input string, converting all the words of the query
 * into their root forms for easier searching and uniformity
 */

@SpringBootApplication
public class LemmatizerApp {

	public static void main(String[] args) {
		SpringApplication.run(LemmatizerApp.class, args);
	}
}
