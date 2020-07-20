package com.lk.基础;

import java.util.function.DoubleBinaryOperator;

public enum OperationEnum {
    //
    PLUS("+", (x, y) -> x + y);
    private final String symbol;
    private final DoubleBinaryOperator operator;

    OperationEnum(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }
}
