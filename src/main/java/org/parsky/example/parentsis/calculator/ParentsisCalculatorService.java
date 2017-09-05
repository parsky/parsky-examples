package org.parsky.example.parentsis.calculator;

import org.parsky.example.parentsis.calculator.parser.ParentsisExpressionParser;

import java.io.PrintStream;

public class ParentsisCalculatorService {
    public static ParentsisCalculatorService calculator () {
        return new ParentsisCalculatorService(new ParentsisExpressionParser());
    }

    private final ParentsisExpressionParser expressionParser;

    public ParentsisCalculatorService(ParentsisExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public void calculate (String input, PrintStream outputStream) {
        outputStream.println(String.format("%s = %d", input, expressionParser.parse(input)
                .orElseThrow(() -> new IllegalArgumentException("Invalid math expression"))
                .calculate()));
    }
}
