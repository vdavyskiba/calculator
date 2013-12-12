package com.teamdev.education.Services;

import com.teamdev.education.Model.BinOperators.BinaryOperator;
import com.teamdev.education.Model.BinaryOperatorsSet;
import com.teamdev.education.Model.States;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Stack;

public class StackMachine {

    public final EnumMap<States, Evaluator> statesEvaluatorMap;
    private final iOnResult onResult;

    private Stack<BigDecimal> operands = new Stack<BigDecimal>();
    private Stack<BinaryOperator> operators = new Stack<BinaryOperator>();
    private Stack<Integer> brackets = new Stack<Integer>();

    public StackMachine(){

        this.onResult = new ResultListener();

        this.statesEvaluatorMap = new EnumMap<States, Evaluator>(States.class);

        createStateEvaluators();
    }

    private void createStateEvaluators(){

        class EvaluateNumber extends Evaluator{

            public void evaluate(String token){
                evaluateNumber(new BigDecimal(token));
            }
        }

        class EvaluateBinOP extends Evaluator{

            public void evaluate(String token){
                evaluateBinOP(token);
            }
        }

        class EvaluateFinish extends Evaluator{

            public void evaluate(String token){
                evaluateFinish();
            }
        }
        class EvaluateLeftBracket extends Evaluator{

            public void evaluate(String token){
                evaluateLeftBracket();
            }
        }
        class EvaluateRightBracket extends Evaluator{

            public void evaluate(String token){
                evaluateRightBracket();
            }
        }

        statesEvaluatorMap.put(States.NUMBER, new EvaluateNumber());
        statesEvaluatorMap.put(States.BIN_OP, new EvaluateBinOP());
        statesEvaluatorMap.put(States.FINISH, new EvaluateFinish());
        statesEvaluatorMap.put(States.LFT_BR, new EvaluateLeftBracket());
        statesEvaluatorMap.put(States.RHT_BR, new EvaluateRightBracket());
    }


    private void evaluateNumber(BigDecimal token){
        operands.push(token);
    }

    private void evaluateBinOP(String token){

        BinaryOperator binOperator = new BinaryOperatorsSet().binaryOperators.get(token);

        if (getBinOPsInBracket()>0) {
            while (getBinOPsInBracket() > 0 && binOperator.priority.intValue() <= operators.peek().priority.intValue())
                executeBinOp();
        }
        operators.push(binOperator);
    }

    private void evaluateFinish(){

        executeAll();

        BigDecimal result = operands.peek();

        onResult.onResult(result);

        //self stack test
        int numbs = operands.size();
        int opers = operators.size();
        int brkts = brackets.size();
        //System.out.println("stacks: " + "operands " + operands.size() +", operators " + operators.size() + ", brackets " + brackets.size());
        System.out.println("test stacks: " + (numbs == 1 && opers == 0 && brkts == 0 ? "ok" : "error") );
    }

    private void evaluateLeftBracket(){
        brackets.push(getBinOPsInBracket());
    }

    private void evaluateRightBracket(){

        int count = brackets.peek();
        if(count > 0){
            while (count > 0){
                while (getBinOPsInBracket() > 0) executeBinOp();
                count--;
            }
        } else {
            executeAll();
        }

        brackets.pop();
    }

    private void executeAll(){
        while(operands.size() >1) executeBinOp();
    }

    private int getBinOPsInBracket(){
        return operators.size() - (brackets.size() > 0 ? getAllSum(brackets) : 0);
    }

    private void executeBinOp(){

        LinkedList<BigDecimal> bigDecimals = new LinkedList<BigDecimal>();
        bigDecimals.push(operands.pop());
        bigDecimals.push(operands.pop());

        BinaryOperator operator = operators.pop();

        BigDecimal result = operator.execute(bigDecimals);

        operands.push(result);
    }

    private int getAllSum(Stack<Integer> stack){
        int sum = 0;
        for(int value : stack) sum += value;
        return sum;
    }
}
