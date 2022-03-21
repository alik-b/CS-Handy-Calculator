package com.alikbCalculator.model;

/**
 * Class that holds the unit and the value of the unit.
 *
 * @param <T> Generic type that represents Size, Rate, or Frequency
 * @author Alik Balika
 * @version 2020.11.04
 */
public abstract class Unit<T> {

    /**
     * double holding the value
     * Generic type T holds a Size, Rate or Frequency enum
     */
    double value;
    T unit;

    /**
     * Constructor that initializes the fields with the parameters. Displays an error message if value is negative.
     *
     * @param unit  Specific enum unit of type Size, Rate, or Frequency
     * @param value value of the unit
     */
    public Unit(T unit, double value) {
        if (value < 0) {
            System.out.println("Value cannot be negative!");
        } else {
            this.value = value;
        }
        this.unit = unit;
    }

    /**
     * @return the unit generic type
     */
    public T getUnit() {
        return unit;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * sets the unit of this class to the unit the user passed in the method
     * @param unit that user passed in
     */
    public void setUnit(T unit) {
        this.unit = unit;
    }

    /**
     * sets the value of this class to the value the user passed in the method
     * @param value that user passed in
     */
    public void setValue(double value) {
        if (value < 0) {
            System.out.println("Value cannot be negative!");
        } else {
            this.value = value;
        }
    }

    /**
     * @return the info as a String
     */
    public String toString() {
        return "Data Unit: " + getUnit() + "      Value: " + getValue();
    }

}
