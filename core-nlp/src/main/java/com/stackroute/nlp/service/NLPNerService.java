package com.stackroute.nlp.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.kafka.SenderPoS;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;


@Service
public class NLPNerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	
	
	@Autowired
	SenderPoS sender;
	
	NerModel nermodel=new NerModel();
	public void findName(String[] words) throws IOException {
		
		
		InputStream is = new FileInputStream("ner-custom-model.bin");

		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);



		String[] result=new String[words.length];
		Span nameSpans[]=null;
			for (int i=0;i<words.length;i++) {
			nameSpans = nameFinder.find(words);
			


			// nameSpans contain all the possible entities detected
			for(Span s: nameSpans){
				logger.info(s.toString());
				logger.info("  :  ");
				// s.getStart() : contains the start index of possible name in the input string array
				// s.getEnd() : contains the end index of the possible name in the input string array
				for(int index=s.getStart();index<s.getEnd();index++){
					result[index]=words[index];
					
					logger.info("RESULT");
					logger.info(result[index]+" ");
				}
				logger.info(null);
				
				for(int i1=0;i1<result.length;i1++)
					logger.info(result[i1]);
		}

			
		}
			
			nermodel.setKeywords(result);
			nermodel.setWords(words);
			sender.sendner(nermodel);
			
			
	}
	
	

		
	}
	




