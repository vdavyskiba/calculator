package com.teamdev.education.Services;

import com.teamdev.education.Model.TransMatrix;

public class Calculation {

    public Calculation(String expression) {

        new FiniteStateMachine(new TransMatrix(), new StackMachine(), expression);

    }

}
