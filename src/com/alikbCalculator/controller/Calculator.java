package com.alikbCalculator.controller;
import com.alikbCalculator.model.Number;

/**
 * Abstract Calculator object that contains all the common methods for all three calculators.
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public abstract class Calculator {

    public abstract Number add(Number num1, Number num2);
    public abstract Number subtract(Number num1, Number num2);
    public abstract Number multiply(Number num1, Number num2);
    public abstract String divide(Number num1, Number num2);

}
