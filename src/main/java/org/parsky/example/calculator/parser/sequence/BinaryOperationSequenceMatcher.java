package org.parsky.example.calculator.parser.sequence;

import org.parsky.example.calculator.model.BinaryOperationExpression;
import org.parsky.example.calculator.model.BinaryOperator;
import org.parsky.example.calculator.model.Expression;
import org.parsky.sequence.SequenceMatchers;
import org.parsky.sequence.TypedSequenceMatcher;
import org.parsky.sequence.infix.InfixExpressionsSequenceMatcher;
import org.parsky.sequence.infix.configuration.InfixExpressionsConfigurationBuilder;

public class BinaryOperationSequenceMatcher extends InfixExpressionsSequenceMatcher<Expression, BinaryOperator> {
    public BinaryOperationSequenceMatcher(TypedSequenceMatcher<Expression> numberSequenceMatcher) {
        super(InfixExpressionsConfigurationBuilder.<Expression, BinaryOperator>infixExpressionsConfiguration()
                .withExpressionParser(SequenceMatchers.skipWhitespaces(numberSequenceMatcher))
                .withCombinedExpressionFactory((left, infix, right) -> new BinaryOperationExpression(left, right, infix))
                .withInfix("+", BinaryOperator.SUM, 10)
                .withInfix("-", BinaryOperator.SUB, 10)
                .withInfix("*", BinaryOperator.MULT, 1)
                .withInfix(":", BinaryOperator.DIV, 0)
                .build());
    }
}
