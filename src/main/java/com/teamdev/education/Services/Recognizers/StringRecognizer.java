package com.teamdev.education.Services.Recognizers;

public class StringRecognizer extends AbstractRecognizer {

    private final String[] tokens;

    public StringRecognizer(String[] tokens){
        this.tokens = tokens;
    }
    public String recognize(String expr){

        for (String token : this.tokens) {

            if(expr.startsWith(token))return token;
        }
        return null;
    }

}
