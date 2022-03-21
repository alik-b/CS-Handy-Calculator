package com.alikbCalculator.model;

/**
 * Class that holds the size unit and its value
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class SizeUnit extends Unit<Size> {

    /**
     * Constructor that initializes the fields with the parameters. Displays an error message if value is negative.
     *
     * @param size  Specific enum unit of type Size
     * @param value value of the unit
     */
    public SizeUnit(Size size, double value) {
        super(size, value);
    }

    /**
     * takes in an int and then goes through a switch statement to determine which Size object to return
     *
     * @param choice index from the JComboBox
     * @return a new Size object depending on the index
     */
    public static Size intChooserDataUnitConverter(int choice) {
        Size size;
        size = switch (choice) {
            case 0 -> Size.BIT;
            case 1 -> Size.KILOBIT;
            case 2 -> Size.MEGABIT;
            case 3 -> Size.GIGABIT;
            case 4 -> Size.TERABIT;
            case 5 -> Size.BYTE;
            case 6 -> Size.KILOBYTE;
            case 7 -> Size.MEGABYTE;
            case 8 -> Size.GIGABYTE;
            case 9 -> Size.TERABYTE;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        return size;
    }

    /**
     * takes in an int and then goes through a switch statement to determine which Size object to return
     *
     * @param choice index from the JComboBox
     * @return a new Size object depending on the index
     */
    public static Size intChooserOther(int choice) {
        Size size;
        size = switch (choice) {
            case 0 -> Size.BYTE;
            case 1 -> Size.KILOBYTE;
            case 2 -> Size.MEGABYTE;
            case 3 -> Size.GIGABYTE;
            case 4 -> Size.TERABYTE;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        return size;
    }

}
