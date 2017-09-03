package org.parsky.example.calculator;

import org.junit.Test;

public class CalculatorServiceTest {
    @Test
    public void calculatorExample() throws Exception {
        CalculatorService calculator = CalculatorService.calculator();
        calculator.calculate("3 + 2", System.out);
        calculator.calculate("3 * 2", System.out);
        calculator.calculate("3 : 2", System.out);
        calculator.calculate("3 : 2 * 5 + 12", System.out);
        calculator.calculate("3 * 2 : 2 + 12", System.out);
    }
}