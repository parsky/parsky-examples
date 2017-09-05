package org.parsky.example.parentsis.calculator;

import org.junit.Test;

public class ParentsisCalculatorServiceTest {
    @Test
    public void example() throws Exception {
        ParentsisCalculatorService.calculator().calculate("3 * (2 + 1)", System.out);
        ParentsisCalculatorService.calculator().calculate("3 * 2 + 1", System.out);
    }
}