package org.apps.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public enum ArithmeticOperationUC14 {

    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    DIVIDE((a, b) -> {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    });

    private final DoubleBinaryOperator operator;

    ArithmeticOperationUC14(DoubleBinaryOperator operator) {
        this.operator = operator;
    }

    public double apply(double a, double b) {
        return operator.applyAsDouble(a, b);
    }
}