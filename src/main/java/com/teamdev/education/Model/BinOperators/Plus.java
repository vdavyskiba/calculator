package com.teamdev.education.Model.BinOperators;

import java.math.BigDecimal;
import java.util.LinkedList;


public class Plus extends BinaryOperator {

    public Plus(Number priority) {
        super(priority);
    }

    @Override
    public BigDecimal execute(LinkedList<BigDecimal> bigDecimals) {

        BigDecimal op1 = bigDecimals.remove();
        BigDecimal op2 = bigDecimals.remove();
        return op1.add(op2);
    }

}
