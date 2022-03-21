package com.alikbCalculator.model;

/**
 * Class that holds the rate unit and its value
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class RateUnit extends Unit<Rate> {

    /**
     * Constructor that initializes the fields with the parameters. Displays an error message if value is negative.
     *
     * @param rate  Specific enum unit of type Rate
     * @param value value of the unit
     */
    public RateUnit(Rate rate, double value) {
        super(rate, value);
    }

    /**
     * takes in an int and then goes through a switch statement to determine which Rate object to return
     *
     * @param choice index from the JComboBox
     * @return a new Rate object depending on the index
     */
    public static Rate intChooser(int choice) {
        Rate rate;
        rate = switch (choice) {
            case 0 -> Rate.BITpS;
            case 1 -> Rate.KBITpS;
            case 2 -> Rate.MBITpS;
            case 3 -> Rate.GBITpS;
            case 4 -> Rate.TBITpS;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        return rate;
    }

}
