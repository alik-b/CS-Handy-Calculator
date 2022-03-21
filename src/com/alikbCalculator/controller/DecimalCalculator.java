package com.alikbCalculator.controller;

import com.alikbCalculator.model.Decimal;
import com.alikbCalculator.model.Number;

/**
 * Subclass of the Calculator object. It deals with Decimal objects.
 * @author Alik Balika
 * @version 2020.11.04
 */
public class DecimalCalculator extends Calculator {

    /**
     * Adds 2 Decimal numbers together and returns the result
     *
     * @param num1 first decimal number
     * @param num2 second decimal number
     * @return new Decimal object containing the sum of num1 and num2
     */
    @Override
    public Decimal add(Number num1, Number num2) {
        return new Decimal(num1.toDecimal() + num2.toDecimal());
    }

    /**
     * Subtracts 2 Decimal numbers and returns the result
     *
     * @param num1 first decimal number
     * @param num2 second decimal number
     * @return new Decimal object containing the difference of num1 and num2
     */
    @Override
    public Decimal subtract(Number num1, Number num2) {
        return new Decimal(num1.toDecimal() - num2.toDecimal());
    }

    /**
     * Multiplies 2 Decimal numbers together and returns the result
     *
     * @param num1 first decimal number
     * @param num2 second decimal number
     * @return new Decimal object containing the product of num1 and num2
     */
    @Override
    public Decimal multiply(Number num1, Number num2) {
        return new Decimal(num1.toDecimal() * num2.toDecimal());
    }

    /**
     * Divides 2 Decimal numbers together and returns the result
     *
     * @param num1 first decimal number
     * @param num2 second decimal number
     * @return new String containing the quotient of num1 and num2 and the remainder
     */
    @Override
    public String divide(Number num1, Number num2) {
        Decimal quotient = new Decimal(num1.toDecimal() / num2.toDecimal());
        Decimal remainder = new Decimal(num1.toDecimal() % num2.toDecimal());
        return quotient + " Remainder: " + remainder;
    }

}
