package com.teamdev.education.UI.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterface{

    private String expression;

    public ConsoleInterface () throws IOException {
        inputString();
    }

    private void inputString() throws  IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            this.expression = bufferedReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getExpression(){
        return expression;
    }

    public void printExpression(){
        System.out.println("your expression " + this.expression);
    }
}
