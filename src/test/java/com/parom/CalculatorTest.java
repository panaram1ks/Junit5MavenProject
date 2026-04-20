package com.parom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "Division did not produce expected result, 4 / 2 did not produce 2");
    }

    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){

    }

    // TODO: Create a new JUnit Test method for integerSubtraction method.
    @Test
    void integerSubtraction() {
        Calculator calculator = new Calculator();
        int subtrahend = 2;
        int minuend = 10;
        int expectedResult = 8;
        int actualResult = calculator.subtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }



}