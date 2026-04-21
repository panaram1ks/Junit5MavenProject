package com.parom;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("repeated test class")
public class DemoRepeatedTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @AfterEach
    void cleanUp() {
        this.calculator = null;
    }

    @DisplayName("Division by zero")
//    @RepeatedTest(3)
    @RepeatedTest(value = 3, name = "{displayName}, Repetition {currentRepetition} of " +
            "{totalRepetitions}")
    void testIntegerDivisionByZero(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {

        System.out.println(repetitionInfo.getCurrentRepetition());
        System.out.println(testInfo.getTestMethod().get().getName());

        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> {    // Act
                    int result = calculator.integerDivision(dividend, divisor);
                },
                "Division by zero should have thrown an Arithmetic exception.");

        // Assert
        assertEquals(expectedExceptionMessage, arithmeticException.getMessage());

    }

}
