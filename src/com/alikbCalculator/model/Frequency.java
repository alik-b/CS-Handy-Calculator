package com.alikbCalculator.model;

/**
 * enum that holds the frequency names and their factors
 * @author Alik Balika
 * @version 2020.11.04
 */
public enum Frequency {

    SECOND(2_629_800.0), MINUTE(43_830.0), HOUR(730.5), DAY(30.4375), WEEK(4.3482142857143),
    MONTH(1), YEAR(0.083333333333333);

    double factor;

    Frequency(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
