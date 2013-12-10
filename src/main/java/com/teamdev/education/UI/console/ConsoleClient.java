package com.teamdev.education.UI.console;

import com.teamdev.education.UI.ExpressionListener;
import com.teamdev.education.UI.iOnExpressionInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleClient {

    private final iOnExpressionInput onExprInput;


    public ConsoleClient() throws IOException {
        this.onExprInput = new ExpressionListener();
        while(true) inputString();
    }

    private void inputString() throws  IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String expression = bufferedReader.readLine();

            if (expression.equals("q")) System.exit(1);

            if (expression.length() > 0){
                onExprInput.OnExprInput(expression);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
