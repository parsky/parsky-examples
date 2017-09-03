package org.parsky.example.calculator.model;

public class BinaryOperationExpression implements Expression {
    private final Expression left;
    private final Expression right;
    private final BinaryOperator operator;

    public BinaryOperationExpression(Expression left, Expression right, BinaryOperator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public int calculate() {
        return operator.getCalculator().apply(left.calculate(), right.calculate());
    }
}
