package com.teamdev.education.Model.BinOperators;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Divide extends BinaryOperator {

    public Divide(Number priority) {
        super(priority);
    }

    @Override
    public BigDecimal execute(LinkedList<BigDecimal> bigDecimals) throws ArithmeticException {

        BigDecimal op1 = bigDecimals.remove();
        BigDecimal op2 = bigDecimals.remove();
        //if (op2 == new BigDecimal(0)) throw new Exception("trying to divide by null");
        return op1.divide(op2);

    }
}
