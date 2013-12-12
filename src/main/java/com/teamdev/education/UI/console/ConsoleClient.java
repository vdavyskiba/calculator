package com.teamdev.education.UI.console;

import com.teamdev.education.UI.ExpressionListener;
import com.teamdev.education.UI.iOnExpressionInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleClient {

    private final iOnExpressionInput onExprInput;
    private boolean listen = true;

    public ConsoleClient() throws IOException {

        this.onExprInput = new ExpressionListener();
        while(listen) inputString();
    }

    private void inputString() throws  IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String expression = bufferedReader.readLine();

            if (expression.equals("q")) quit();

            if (expression.length() > 0){
                onExprInput.OnExprInput(expression);
            }

        } catch (IOException e){
            System.out.println(e);
        }
    }

    private void quit(){
        listen = false;
        System.exit(1);
    }

}
