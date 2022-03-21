package com.alikbCalculator.model;

/**
 * Class that holds the frequency unit and its value
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class FrequencyUnit extends Unit<Frequency> {

    /**
     * Constructor that initializes the fields with the parameters. Displays an error message if value is negative.
     *
     * @param frequency Specific enum unit of type Frequency
     * @param value     value of the unit
     */
    public FrequencyUnit(Frequency frequency, double value) {
        super(frequency, value);
    }

    /**
     * takes in an int and then goes through a switch statement to determine which Frequency object to return
     *
     * @param choice index from the JComboBox
     * @return a new Frequency object depending on the index
     */
    public static Frequency intChooserWebsiteBandwidth(int choice) {
        Frequency frequency;
        frequency = switch (choice) {
            case 0 -> Frequency.SECOND;
            case 1 -> Frequency.MINUTE;
            case 2 -> Frequency.HOUR;
            case 3 -> Frequency.DAY;
            case 4 -> Frequency.WEEK;
            case 5 -> Frequency.MONTH;
            case 6 -> Frequency.YEAR;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        return frequency;
    }

}
