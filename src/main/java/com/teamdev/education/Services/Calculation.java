package com.teamdev.education.Services;

import com.teamdev.education.Model.TransMatrix;

public class Calculation {

    private final FiniteStateMachine fsm;
    private String expression;

    public Calculation(String expression) {

        this.expression = expression;

        this.fsm = new FiniteStateMachine(new TransMatrix(), new StackMachine(), this.expression);



    }

}
