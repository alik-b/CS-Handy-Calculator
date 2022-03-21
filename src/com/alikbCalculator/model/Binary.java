package com.alikbCalculator.model;

import com.alikbCalculator.controller.Utils;

/**
 * subclass of the Number class. It holds the value of a binary number
 * @author Alik Balika
 * @version 2020.11.04
 */
public class Binary extends Number {

    /**
     * Constructor that initializes the Binary object
     * @param value specific value entered by the user
     */
    public Binary(String value) {
        super(value);
    }

    /**
     * Overrides the method in Number and sets the field to the value and outputs an error message if it's not valid
     * @param value that represents a specific binary number
     */
    @Override
    public void setValue(String value) {
        if (!Utils.isBinary(value)) {
            System.out.println("Not a valid Binary Number!");
        } else {
            super.setValue(value);
        }
    }

    /**
     * @return The binary value
     */
    @Override
    public String toBinary() {
        return getValue();
    }

    /**
     * @return The hex representation of the binary object
     */
    @Override
    public String toHex() {
        return new Decimal(toDecimal()).toHex();
    }

    /**
     * @return The decimal representation of the binary object
     */
    @Override
    public long toDecimal() {
        long decimal = 0;
        long multiplier = 1;
        for (int i = getValue().length() - 1; i >= 0; i--) {
            char c = getValue().charAt(i);

            if (c == '1') {
                decimal += multiplier;
            }
            multiplier *= 2;
        }
        return decimal;
    }
}
