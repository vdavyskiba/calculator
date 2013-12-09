package com.teamdev.education.Services;

import com.teamdev.education.Model.States;
import com.teamdev.education.Model.TransMatrix;

import java.util.EnumMap;
import java.util.HashMap;

public class FiniteStateMachine {

    private final HashMap<States, States[]> matrix;
    private final EnumMap<States, Evaluator> stackMachineEvaluators;
    private String expression;
    private Enum<States> currentState;

    public FiniteStateMachine(TransMatrix transMatrix, StackMachine stackMachine, String expression){

        this.matrix = transMatrix.matrix;
        this.stackMachineEvaluators = stackMachine.statesEvaluatorMap;
        this.expression = expression;
        this.currentState = States.START;
        this.transition();
    }

    public void transition(){

        while (this.expression.length()>0){

            States[] accessibleStates = this.matrix.get(this.currentState);

            for(States state : accessibleStates){

                String token = state.recognizer.recognize(this.expression);

                if (token != null){

                    String remainExpression = this.expression.substring(token.length());

                    //todo need to refactor: bugfix with "1.100" numbers
                    while(remainExpression.startsWith("0")) remainExpression = remainExpression.substring(1);

                    stackMachineEvaluators.get(state).evaluate(token);

                    this.expression = remainExpression;
                    this.currentState = state;
                    break;


                }
            }
        }

    }

}
