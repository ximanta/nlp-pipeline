package com.stackroute.nlp.kafka;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.service.NLPNerService;
@Service
public class Listener {
    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    

    
    @Autowired
    NLPNerService nerservice;

    
    
    @KafkaListener(id = "foo", topics = "lemmatizer", group = "group2", containerFactory="kafkaListenerContainerFactory")
    public void listen(LemmatizedQuery record) throws IOException {
    	
    	System.out.println("nermodel is listening");
    
    	System.out.println(record.getLemQuery()[0]);
    	System.out.println(record.getLemQuery()[1]);
    	System.out.println(record.getLemQuery()[2]);

      nerservice.findName(record.getLemQuery());
 
        
       countDownLatch1.countDown();
            
        
    }
}