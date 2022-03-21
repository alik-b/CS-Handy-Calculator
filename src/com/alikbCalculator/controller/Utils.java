package com.alikbCalculator.controller;

/**
 * Class that contains common methods that check for errors within Strings entered in by the user.
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class Utils {

    /**
     * Takes in a String entered by the user and returns true if it is valid.
     *
     * @param operator String containing a potential valid operator
     * @return true if the String is a valid operator and false otherwise
     */
    public static boolean isOperator(String operator) {
        return !operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/");
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid. returns false for negative values.
     *
     * @param str String containing a potential valid integer number
     * @return true if the String is a valid integer number and false otherwise
     */
    public static boolean isInteger(String str) {

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return Long.parseLong(str) <= Integer.MAX_VALUE;
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid. returns false for negative values.
     *
     * @param hex String containing a potential valid hex number
     * @return true if the String is a valid hex number and false otherwise
     */
    public static boolean isHex(String hex) {
        if (hex == null || hex.equals("") || hex.length() >= 16) {
            return false;
        }

        for (int i = hex.length() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(hex.charAt(i));

            if (!Character.isDigit(c) && c != 'A' && c != 'B' && c != 'C' && c != 'D'
                    && c != 'E' && c != 'F') {
                return false;
            }
        }
        return true;
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid. returns false for negative values.
     *
     * @param binary String containing a potential valid binary number
     * @return true if the String is a valid binary number and false otherwise
     */
    public static boolean isBinary(String binary) {
        // Tests the case where binary would be empty or null or greater than 16 bits
        if (binary == null || binary.equals("") || binary.length() >= 64) {
            return false;
        }

        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid.
     *
     * @param unit String containing a potential valid unit of time
     * @return true if the String is valid and false otherwise
     */
    public static boolean isValidTimeUnits(String unit) {
        return !unit.toLowerCase().equals("persecond") && !unit.toLowerCase().equals("perminute") && !unit.toLowerCase().equals("perhour") && !unit.toLowerCase().equals("perday")
                && !unit.toLowerCase().equals("perweek") && !unit.toLowerCase().equals("permonth") && !unit.toLowerCase().equals("peryear") && !unit.toLowerCase().equals("per second")
                && !unit.toLowerCase().equals("per minute") && !unit.toLowerCase().equals("per hour") && !unit.toLowerCase().equals("per day")
                && !unit.toLowerCase().equals("per week") && !unit.toLowerCase().equals("per month") && !unit.toLowerCase().equals("per year");
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid. (For converting a data unit)
     *
     * @param unit String containing a potential valid unit of storage
     * @return true if the String is valid and false otherwise
     */
    public static boolean isValidAllKeyword(String unit) {
        return !unit.toLowerCase().equals("bits") && !unit.toLowerCase().equals("kilobits") && !unit.toLowerCase().equals("megabits") && !unit.toLowerCase().equals("gigabits") &&
                !unit.toLowerCase().equals("terabits") && !unit.toLowerCase().equals("bytes") && !unit.toLowerCase().equals("kilobytes") && !unit.toLowerCase().equals("megabytes") &&
                !unit.toLowerCase().equals("gigabytes") && !unit.toLowerCase().equals("terabytes");
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid.
     *
     * @param unit String containing a potential valid unit of storage
     * @return true if the String is valid and false otherwise
     */
    public static boolean isValidBottomKeywords(String unit) {
        return !unit.toLowerCase().equals("bytes") && !unit.toLowerCase().equals("kilobytes") && !unit.toLowerCase().equals("megabytes") &&
                !unit.toLowerCase().equals("gigabytes") && !unit.toLowerCase().equals("terabytes");
    }

    /**
     * Takes in a String entered by the user and returns true if it is valid.
     *
     * @param unit String containing a potential valid bandwidth
     * @return true if the String is valid and false otherwise
     */
    public static boolean isValidUnitPerTimeKeywords(String unit) {
        return !unit.toLowerCase().equals("bit/s") && !unit.toLowerCase().equals("kbit/s") && !unit.toLowerCase().equals("mbit/s") &&
                !unit.toLowerCase().equals("gbit/s") && !unit.toLowerCase().equals("tbit/s");
    }
}
