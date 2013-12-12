package com.teamdev.education.Services;

import com.teamdev.education.Model.States;
import com.teamdev.education.Model.TransMatrix;

import java.util.EnumMap;
import java.util.HashMap;

class StateMachine {

    private final HashMap<States, States[]> matrix;
    private final EnumMap<States, Evaluator> stackMachineEvaluatorMap;
    private final String sourceExpression;

    private Enum<States> currentState;
    private String workExpression;

    public StateMachine(TransMatrix transMatrix, StackMachine stackMachine, String expression){

        this.matrix = transMatrix.matrix;
        this.stackMachineEvaluatorMap = stackMachine.statesEvaluatorMap;
        this.currentState = States.START;
        //adding finish state
        String expr = expression + "=";
        this.sourceExpression = expr;
        this.workExpression = expr;

        this.transition();
    }

    private void transition() {

        boolean changed;

        while (this.workExpression.length()>0){

            changed = false;
            States[] accessibleStates = this.matrix.get(this.currentState);

            for(States state : accessibleStates){

                String token = state.recognizer.recognize(this.workExpression);

                if (token != null){
                    String remainExpression = this.workExpression.substring(token.length());
                    Evaluator evaluator = stackMachineEvaluatorMap.get(state);

                    //catch arithmetic exceptions
                    try {
                        evaluator.evaluate(token);
                    } catch (ArithmeticException e){
                        System.out.println(e);
                        System.out.println("Error: symbol position: [" + sourceExpression.indexOf(workExpression) + "] " + " invalid expression : [" + sourceExpression.substring(workExpression.length(), sourceExpression.indexOf(workExpression)) + "]");
                        return;
                    }

                    this.workExpression = remainExpression;
                    this.currentState = state;
                    changed = true;
                    break;
                }
            }
            //unrecognized symbol
            if (!changed) {
                System.out.println("Error: symbol position: [" + (sourceExpression.indexOf(workExpression) + 1) + "] un-allowed symbol: \"" + workExpression.charAt(0) + "\"");
                return;
            }
        }

    }

}
