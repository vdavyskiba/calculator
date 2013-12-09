package com.teamdev.education.Model.BinOperators;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Minus extends BinaryOperator {

    public Minus(Number priority) {
        super(priority);
    }

    @Override
    public BigDecimal execute(LinkedList<BigDecimal> bigDecimals) {

        BigDecimal op1 = bigDecimals.remove();
        BigDecimal op2 = bigDecimals.remove();

        return op1.subtract(op2);
    }
}
