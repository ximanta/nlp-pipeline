package com.stackroute.lemmatizer.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.lemmatizer.domain.LemmatizedQuery;
import com.stackroute.lemmatizer.messenger.Sender;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;

/*
 * This service performs the work of lemmatization. Two string arrays, one containing the words 
 * of the input sentence and the other containing the parts of speech of the respective words are
 * taken and used to perform lemmatization.
 */

@Service
public class LemmatizerAppService {

	private static Logger logger = LoggerFactory.getLogger(LemmatizerAppService.class);
	
//	Invoking an object of the model class
	
	LemmatizedQuery lemmatizedQuery = new LemmatizedQuery();
	
	@Autowired
	Sender sender;
	
//	Method for lemmatizing the input string
	public LemmatizedQuery lemmatizedString(String[] sentence, String[] PoS) throws IOException {
		
//		en-lemmatizer.txt is the lemmatizer file provided by OpenNLP for English lemmatization
		InputStream dictLemmatizer = new FileInputStream("en-lemmatizer.txt");
		DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
		
		for(int i=0;i<sentence.length;i++) {
			
				if(PoS[i].equals("NNP")  ) {
					PoS[i] = "NN";
				}
			}
		
//		Lemmatizing the input string and storing it
		String[] lemmas = lemmatizer.lemmatize(sentence, PoS);
		
//		logging the output in the console
		logger.info("WORD - POSTAG : LEMMA");
		for(int j=0; j<sentence.length;j++) {
			logger.info(sentence[j]+" - "+PoS[j]+" : "+lemmas[j]);
		}
		
		lemmatizedQuery.setLemQuery(lemmas);
		return lemmatizedQuery;
	}
}
