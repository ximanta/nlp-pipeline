package com.stackroute.lemmatizer.messenger;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;
import com.stackroute.lemmatizer.domain.StopWordsModel;
import com.stackroute.lemmatizer.service.LemmatizerAppService;

@Service
public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
	
	
	@Autowired
	Sender sender;
	
	
	
	
	
	LemmatizerAppService lemmatizerAppService=new LemmatizerAppService();

	
	@KafkaListener(id = "foo", topics = "stopwords", group = "group1")
	public void listen(StopWordsModel record) throws IOException {
	
		
//		StopWordsModel 
		System.out.println(record);
		
		String[] getwords=record.getWords();
		
		String[] getpos=record.getPos();
		

		for(String word:getwords)
			System.out.println(word);
		
		for(String word:getpos)
			System.out.println(word);
		
		LemmatizedQuery result=lemmatizerAppService.lemmatizedString(getwords, getpos);
		System.out.println("The result is:");
		System.out.println(result.getLemQuery());
		
		sender.send(result);
		
		
		countDownLatch1.countDown();
			
		
	}
}