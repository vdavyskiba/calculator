package com.teamdev.education.Model;

import com.teamdev.education.Services.Recognizers.AbstractRecognizer;
import com.teamdev.education.Services.Recognizers.NumberRecognizer;
import com.teamdev.education.Services.Recognizers.StringRecognizer;

public enum States {
    START("#"),
    FINISH("="),
    NUMBER(new NumberRecognizer()),
    /*NUMBER(new String[] {"0","1","2","3","4","5","6","7","8","9"}),*/
    BIN_OP(new BinaryOperatorsSet().binaryOperators.keySet().toArray(new String[new BinaryOperatorsSet().binaryOperators.keySet().size()])),
    LFT_BR("("),
    RHT_BR(")");

    public final AbstractRecognizer recognizer;

    private final String[] code;

    private States(String[] symbols){
        this.code = symbols;
        this.recognizer = new StringRecognizer(symbols);
    }

    private States(String symbols){
        this.code = new String[] {symbols};
        this.recognizer = new StringRecognizer(new String[] {symbols});
    }

    private States(AbstractRecognizer recognizer){
        this.code = new String[] {};
        this.recognizer = new NumberRecognizer();
    }

}
