package com.alikbCalculator.controller;

import com.alikbCalculator.model.Decimal;
import com.alikbCalculator.model.Hex;
import com.alikbCalculator.model.Number;

/**
 * Subclass of the Calculator object. It deals with Hex objects.
 * @author Alik Balika
 * @version 2020.11.04
 */
public class HexCalculator extends Calculator {

    /**
     * Adds 2 Hex numbers together and returns the result
     *
     * @param num1 first hex number
     * @param num2 second hex number
     * @return new Hex object containing the sum of num1 and num2
     */
    @Override
    public Hex add(Number num1, Number num2) {
        Decimal sum = new Decimal(num1.toDecimal() + num2.toDecimal());
        return new Hex(sum.toHex());
    }

    /**
     * Subtracts 2 Hex numbers and returns the result
     *
     * @param num1 first hex number
     * @param num2 second hex number
     * @return new Hex object containing the difference of num1 and num2
     */
    @Override
    public Hex subtract(Number num1, Number num2) {
        Decimal sum = new Decimal(num1.toDecimal() - num2.toDecimal());
        return new Hex(sum.toHex());
    }

    /**
     * Multiplies 2 Hex numbers together and returns the result
     *
     * @param num1 first hex number
     * @param num2 second hex number
     * @return new Hex object containing the product of num1 and num2
     */
    @Override
    public Hex multiply(Number num1, Number num2) {
        Decimal sum = new Decimal(num1.toDecimal() * num2.toDecimal());
        return new Hex(sum.toHex());
    }

    /**
     * Divides 2 Hex numbers together and returns the result
     *
     * @param num1 first hex number
     * @param num2 second hex number
     * @return new String containing the quotient of num1 and num2 and the remainder
     */
    @Override
    public String divide(Number num1, Number num2) {
        Decimal quotient = new Decimal(num1.toDecimal() / num2.toDecimal());
        Decimal remainder = new Decimal(num1.toDecimal() % num2.toDecimal());
        return "Hex Value: " + quotient.toHex() + " Remainder: " + remainder.toHex() + "     " +
                "Decimal Value: " + quotient + " Remainder: " + remainder;
    }

}
