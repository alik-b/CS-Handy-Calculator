package com.alikbCalculator.model;

import com.alikbCalculator.controller.Utils;

/**
 * subclass of the Number class. It holds the value of a hex number
 * @author Alik Balika
 * @version 2020.11.04
 */
public class Hex extends Number {

    /**
     * Constructor that initializes the Hex object
     * @param value specific value entered by the user
     */
    public Hex(String value) {
        super(value);
    }

    /**
     * Overrides the method in Number and sets the field to the value and outputs an error message if it's not valid
     * @param value that represents a specific hex number
     */
    @Override
    public void setValue(String value) {
        if (!Utils.isHex(value)) {
            System.out.println("Not a valid Hex Number!");
        } else {
            super.setValue(value);
        }
    }

    /**
     * @return The binary representation of the hex object
     */
    @Override
    public String toBinary() {
        return new Decimal(toDecimal()).toBinary();
    }

    /**
     * @return The hex value
     */
    @Override
    public String toHex() {
        return getValue().toUpperCase();
    }

    /**
     * @return The decimal representation of the hex object
     */
    @Override
    public long toDecimal() {
        long decimal = 0;
        long multiplier = 1;
        for (int i = getValue().length() - 1; i >= 0; i--) {
            int charAtI;
            char c = Character.toUpperCase(getValue().charAt(i));

            if (c <= 57) {
                charAtI = c - 48;
            } else {
                charAtI = c - 55;
            }

            decimal += charAtI * multiplier;

            multiplier *= 16;
        }
        return decimal;
    }
}
