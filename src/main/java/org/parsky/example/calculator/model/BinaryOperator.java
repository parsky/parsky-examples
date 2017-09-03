package org.parsky.example.calculator.model;

import java.util.function.BiFunction;

public enum BinaryOperator {
    SUM((left, right) -> left + right),
    SUB((left, right) -> left - right),
    MULT((left, right) -> left * right),
    DIV((left, right) -> left / right),

    ;

    private final BiFunction<Integer, Integer, Integer> calculator;

    BinaryOperator(BiFunction<Integer, Integer, Integer> calculator) {
        this.calculator = calculator;
    }

    public BiFunction<Integer, Integer, Integer> getCalculator() {
        return calculator;
    }
}
