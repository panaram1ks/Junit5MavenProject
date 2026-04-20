package com.parom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void integerDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "Division did not produce expected result, 4 / 2 did not produce 2");
    }

    // TODO: Create a new JUnit Test method for integerSubtraction method.
    @Test
    void integerSubtraction(){
        Calculator  calculator = new Calculator();
        int result = calculator.subtraction(10, 2);
        assertEquals(8, result);
    }

}