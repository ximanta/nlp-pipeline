package com.stackroute.lemmatizer.domain;


public class StopWordsModel {

    private String[] words;

    private String[] pos;

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getPos() {
        return pos;
    }

    public void setPos(String[] pos) {
        this.pos = pos;
    }

    public StopWordsModel() {
		
	}

	public StopWordsModel(String[] words, String[] pos) {
		super();
		this.words = words;
		this.pos = pos;
	}
    
}
