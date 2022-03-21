package com.alikbCalculator.model;

import com.alikbCalculator.controller.Convertible;

/**
 * Abstract Number type that holds a value of that number and has an accessor/mutator method for the value
 * @author Alik Balika
 * @version 2020.11.04
 */
public abstract class Number implements Convertible {

    /**
     * String representing the value of the number
     */
    private String value;

    /**
     * Constructor that initializes the Number object
     *
     * @param value specific value entered by the user
     */
    public Number(String value) {
        this.value = value;
    }

    /**
     * @return the value of the field in uppercase
     */
    public String getValue() {
        return this.value.toUpperCase();
    }

    /**
     * Sets the field to the value
     * @param value that represents a specific number
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the value of the as a String
     */
    public String toString() {
        return getValue();
    }
}
