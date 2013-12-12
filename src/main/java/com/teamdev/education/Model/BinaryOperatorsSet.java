package com.teamdev.education.Model;

import com.teamdev.education.Model.BinOperators.*;


import java.util.HashMap;

public class BinaryOperatorsSet {

    public final HashMap<String, BinaryOperator> binaryOperators;

    public BinaryOperatorsSet() {

        HashMap<String, BinaryOperator> binaryOperators = new HashMap<String, BinaryOperator>();

        binaryOperators.put("+", new Plus(1));
        binaryOperators.put("-", new Minus(1));
        binaryOperators.put("*", new Mul(2));
        binaryOperators.put("/", new Divide(2));

        this.binaryOperators = binaryOperators;
    }
}
