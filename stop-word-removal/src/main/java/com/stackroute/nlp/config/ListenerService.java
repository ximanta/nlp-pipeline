package com.stackroute.nlp.config;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.PoS;
import com.stackroute.nlp.service.StopWordsService;



@Service
public class ListenerService {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    
    @Autowired
    StopWordsService stopWordsService;
  
  
    
    @Autowired
    SenderService sender;

    
    @KafkaListener(id = "foo", topics = "posproducer", group = "group1")
    public void listen(PoS record) throws IOException {
    
//        System.out.println(record.getPosmap());
//        System.out.println(record.getUserInput());
    	
    	String[] words=record.getWords();
    	String[] pos=record.getPos();
    	
    	for (int i=0;i<words.length;i++) {
    	System.out.println(words[i]);
    	System.out.println(pos[i]);
    	}
     
    	stopWordsService.removeStopwords(words, pos);
     //   sender.send(result);
        
        
        countDownLatch1.countDown();
            
        
    }
}
