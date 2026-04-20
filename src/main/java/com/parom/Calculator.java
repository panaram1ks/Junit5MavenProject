package com.parom;

public class Calculator {

    public int integerDivision(int dividend, int divisor) {
        return dividend / divisor;
    }

    public int subtraction(int minuend, int subtrahend) {
        return  minuend - subtrahend;
    }

    public double squareRoot(double number) throws IllegalAccessException {
        if(number < 0){
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
}