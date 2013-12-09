package com.teamdev.education.Services.Recognizers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class NumberRecognizer extends AbstractRecognizer {

    public String recognize(String expression){
        return recognizeString(expression);
    }
    public static String recognizeString(String expression){

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        NumberFormat decimalFormat = new DecimalFormat("0,0", decimalFormatSymbols);
        ParsePosition position = new ParsePosition(0);
        Number token = decimalFormat.parse(expression, position);

        return token != null ? token.toString() : null;


    }
}
