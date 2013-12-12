package com.teamdev.education.Services;

import com.teamdev.education.Model.TransMatrix;

public class Calculation {

    public Calculation(String expression, iOnResult onResult) {

        new StateMachine(new TransMatrix(), new StackMachine(onResult), expression);

    }

}
