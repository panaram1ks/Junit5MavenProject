package com.parom;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Execute before All method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Execute After all method");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Execute Before Each method");
        this.calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Execute After Each method");
    }

    @DisplayName("Test 4/2 = 2")
    // test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "Division did not produce expected result, 4 / 2 did not produce 2");
    }

    //    @Disabled
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        // fail("Not implemented yet");
        // Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
//      // Act
//      int result = calculator.integerDivision(dividend, divisor);
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> {    // Act
                    int result = calculator.integerDivision(dividend, divisor);
                },
                "Division by zero should have thrown an Arithmetic exception.");

        // Assert
        assertEquals(expectedExceptionMessage, arithmeticException.getMessage());

    }

    // TODO: Create a new JUnit Test method for integerSubtraction method.
    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    @MethodSource()
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        // AAA
        // Arrange(Given) -> Act(When) -> Assert(Then)
//        int subtrahend = 2;
//        int minuend = 10;
//        int expectedResult = 8;

        int actualResult = calculator.subtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }

    private static Stream<Arguments> integerSubtraction() {
        return Stream.of(
                Arguments.of(33, 1, 32),
                Arguments.of(10, 2, 8),
                Arguments.of(22, 21, 1)
        );
    }

    @Test
    void testSquareRoot_whenNumberBelowZero_ShouldThrowIllegalArgException() {
        //Arrange
        double number = -10.0;

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            //Act
            double squareRoot = calculator.squareRoot(number);
        });

        //Assertion
        assertEquals(illegalArgumentException.getClass(), IllegalArgumentException.class);
    }

    @Test
    void testSquareRoot_whenNumberIsNormal_ShouldProvideCalculation() throws IllegalAccessException {
        double number = 100;

        double squareRoot = calculator.squareRoot(number);

        assertEquals(10, squareRoot);
    }

    @DisplayName("CSV integer parameters")
    @ParameterizedTest
    @CsvSource({
            "33,1,32",
            "22,20,2",
            "99,90,9",
    })
    void integerSubtractionCSV(int minuend, int subtrahend, int expectedResult) {
        int actualResult = calculator.subtraction(minuend, subtrahend);

        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }

    @DisplayName("CSV string parameters")
    @ParameterizedTest
    @CsvSource({
            "apple, orange",
            "apple, ''", // second parameter is empty string
            "apple,"    // second parameter will be null
    })
    void stringSubtractionCSV(String firstLine, String secondLine) {
        assertEquals("apple", firstLine);
    }

    @DisplayName("CSV string parameters in File")
    @ParameterizedTest
    @CsvFileSource(resources = "/stringSubtractionCSVfile.csv")
    void stringSubtractionCSVfile(String firstLine, String secondLine) {
        assertEquals("apple", firstLine);
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Kate", "Alice"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }


}