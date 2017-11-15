package com.stackroute.nlp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.domain.PosModel;



@Service
public class SenderPoS {
	
	@Autowired
	private KafkaTemplate<String, PosModel> kafkaTemplate;


	String kafkaTopic="posproducer";
	
	
	@Autowired
	private KafkaTemplate<String, NerModel> kafkaTemplate1;
	
	String kafkaTopic1="nerproducer4";
	
	public void send(PosModel posmodel) {
		

		kafkaTemplate.send(kafkaTopic, posmodel);
		System.out.println("PoS Model is sending: ");
		System.out.println(posmodel.getWords());
		System.out.println(posmodel.getPos());
		

		
	}
	
public void sendner(NerModel nermodel) {
		
	System.out.print("Ner model is sending: ");
	for (int i=0;i<nermodel.getKeywords().length;i++)
	System.out.println(nermodel.getKeywords()[i]);
		kafkaTemplate1.send(kafkaTopic1, nermodel);
		
		
	}

}
