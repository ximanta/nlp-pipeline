package com.stackroute.nlp.domain;

public class NerModel {
    
	// Query stored in array of strings words
	private String[] words;
	// Keywords stored in array of strings keywords
	private String[] keywords;

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}


	
	public NerModel(String[] words, String[] keywords) {
		super();
		this.words = words;
		this.keywords = keywords;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public NerModel() {
		super();
	}





}
