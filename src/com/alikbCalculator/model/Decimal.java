package com.alikbCalculator.model;

/**
 * subclass of the Number class. It holds the value of a decimal number
 * @author Alik Balika
 * @version 2020.11.04
 */
public class Decimal extends Number {

    /**
     * long that holds the value of the decimal number
     */
    public long decimal;

    /**
     * Constructor calls its super method with the long value and an empty String. Sets the decimal field to value.
     * @param value entered in by the user
     */
    public Decimal(long value) {
        super(value + "");
        decimal = value;
    }

    /**
     * Overrides the method in Number and sets the field to the value and outputs an error message if it's not valid
     * @param decimal value that represents a specific decimal number
     */
    @Override
    public void setValue(String decimal) {
        try {
            this.decimal = Long.parseLong(decimal);
            super.setValue(decimal);
        } catch (NumberFormatException exception) {
            System.out.println("Not a valid Decimal number!");
        }
    }

    /**
     * @return The binary representation of the decimal object
     */
    @Override
    public String toBinary() {
        long temp = decimal;

        // If decimal is zero at the start then return a String with zero
        if (temp == 0) {
            return "0";
        }

        // Takes into account negative numbers
        boolean isNegative = false;
        if (temp < 0) {
            isNegative = true;
            temp *= -1;
        }

        // declare a StringBuilder variable to hold binary values
        StringBuilder binary = new StringBuilder();

        // create a while loop until decimal <= 0
        while (temp > 0) {
            binary.append(temp % 2);
            temp /= 2;
        }

        // adds a - sign if the decimal number was negative originally
        if (isNegative) {
            binary.append("-");
        }

        return binary.reverse().toString();
    }

    /**
     * @return The hex representation of the decimal object
     */
    @Override
    public String toHex() {
        long temp = decimal;
        // if decimal is 0 at the start return 0
        if (temp == 0) {
            return "0";
        }

        // Takes into account negative numbers
        boolean isNegative = false;
        if (temp < 0) {
            isNegative = true;
            temp *= -1;
        }

        // declare a StringBuilder variable to hold hex values
        StringBuilder hex = new StringBuilder();

        // create a while loop until decimal <= 0
        while (temp > 0) {
            int digit = (int)(temp % 16);
            char digitString;
            if (digit <= 9) {
                digitString = (char) (digit + 48);
            } else {
                digitString = (char) (digit + 55);
            }
            hex.append(digitString);
            temp /= 16;
        }

        // adds a - sign if the decimal number was negative originally
        if (isNegative) {
            hex.append("-");
        }
        return hex.reverse().toString();
    }

    /**
     * @return the decimal value
     */
    @Override
    public long toDecimal() {
        return decimal;
    }
}
