package com.teamdev.education;

import com.teamdev.education.Services.Calculation;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        //System.out.println("calculator start");
        String testExpression = "20.4+2*(2+(2+3*(2+4)/(4+6)*8)*9)+(9/4)+2=";

        new Calculation(testExpression);
        /*System.out.println("calculator start");
        System.out.println(testExpression);*/

        //CONSOLE
        /*ConsoleInterface consoleInterface = new ConsoleInterface();
        consoleInterface.printExpression();
        consoleInterface.getExpression();*/

    }


}
