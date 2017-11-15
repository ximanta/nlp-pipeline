package com.stackroute.nlp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.StopWordsResult;

@Service
public class SenderService {

	@Autowired
	private KafkaTemplate<String, StopWordsResult> kafkaTemplate;
	// private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	String kafkaTopic = "stopwords";

	// @Async
	public void send(StopWordsResult message) {

		kafkaTemplate.send(kafkaTopic, message);

		String[] words = message.getWords();
		String[] pos = message.getPos();
		System.out.println("kafka is sending: ");

		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
			System.out.println(pos[i]);
		}
	}
}
