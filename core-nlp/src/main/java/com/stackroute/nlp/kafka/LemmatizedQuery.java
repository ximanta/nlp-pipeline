package com.stackroute.nlp.kafka;

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
    public LemmatizedQuery() {
        // TODO Auto-generated constructor stub
    }
    


    
    
}