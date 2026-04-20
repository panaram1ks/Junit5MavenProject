package com.parom;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup(){
        System.out.println("Execute before All method");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Execute After all method");
    }

    @BeforeEach
    void beforeEachTestMethod(){
        System.out.println("Execute Before Each method");
        this.calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Execute After Each method");
    }

    @DisplayName("Test 4/2 = 2")
    // test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "Division did not produce expected result, 4 / 2 did not produce 2");
    }

    @Disabled
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){
        fail("Not implemented yet");
    }

    // TODO: Create a new JUnit Test method for integerSubtraction method.
    @DisplayName("Test 10 - 2 = 8")
    @Test
    void integerSubtraction() {
        // AAA
        // Arrange(Given) -> Act(When) -> Assert(Then)
        int subtrahend = 2;
        int minuend = 10;
        int expectedResult = 8;

        int actualResult = calculator.subtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }



}