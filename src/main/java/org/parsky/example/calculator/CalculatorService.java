package org.parsky.example.calculator;

import org.parsky.example.calculator.parser.ExpressionParser;

import java.io.PrintStream;

public class CalculatorService {
    public static CalculatorService calculator () {
        return new CalculatorService(new ExpressionParser());
    }

    private final ExpressionParser expressionParser;

    public CalculatorService(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public void calculate (String input, PrintStream outputStream) {
        outputStream.println(String.format("%s = %d", input, expressionParser.parse(input)
                .orElseThrow(() -> new IllegalArgumentException("Invalid math expression"))
                .calculate()));
    }
}
