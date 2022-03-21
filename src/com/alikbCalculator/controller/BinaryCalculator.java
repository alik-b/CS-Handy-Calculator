package com.alikbCalculator.controller;

import com.alikbCalculator.model.Binary;
import com.alikbCalculator.model.Decimal;
import com.alikbCalculator.model.Number;

/**
 * Subclass of the Calculator object. It deals with Binary objects.
 * @author Alik Balika
 * @version 2020.11.04
 */
public class BinaryCalculator extends Calculator {

    /**
     * Adds 2 Binary numbers together and returns the result
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return new Binary object containing the sum of num1 and num2
     */
    @Override
    public Binary add(Number num1, Number num2) {
        Decimal sum = new Decimal(num1.toDecimal() + num2.toDecimal());
        return new Binary(sum.toBinary());
    }

    /**
     * Subtracts 2 Binary numbers and returns the result
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return new Binary object containing the difference of num1 and num2
     */
    @Override
    public Binary subtract(Number num1, Number num2) {
        Decimal difference = new Decimal(num1.toDecimal() - num2.toDecimal());
        return new Binary(difference.toBinary());
    }

    /**
     * Multiplies 2 Binary numbers together and returns the result
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return new Binary object containing the product of num1 and num2
     */
    @Override
    public Binary multiply(Number num1, Number num2) {
        Decimal product = new Decimal(num1.toDecimal() * num2.toDecimal());
        return new Binary(product.toBinary());
    }

    /**
     * Divides 2 Binary numbers together and returns the result
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return new String containing the quotient of num1 and num2 and the remainder
     */
    @Override
    public String divide(Number num1, Number num2) {
        Decimal quotient = new Decimal(num1.toDecimal() / num2.toDecimal());
        Decimal remainder = new Decimal(num1.toDecimal() % num2.toDecimal());
        return "Binary Value: " + quotient.toBinary() + " Remainder: " + remainder.toBinary() + "     " +
                "Decimal Value: " + quotient + " Remainder: " + remainder;
    }

}
