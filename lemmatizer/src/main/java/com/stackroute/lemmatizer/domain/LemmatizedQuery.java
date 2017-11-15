package com.stackroute.lemmatizer.domain;

import java.util.HashMap;
import java.util.Map;

/*
 * Model Class for lemmatizer. It contains the lemmatized query and 
 * the parts of speech of the respective words
 */
public class LemmatizedQuery {

	
	private String[] lemQuery;

	
	public String[] getLemQuery() {
		return lemQuery;
	}
	public void setLemQuery(String[] lemQuery) {
		this.lemQuery = lemQuery;
	}



	
	
}
