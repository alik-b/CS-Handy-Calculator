package com.alikbCalculator.model;

/**
 * enum that holds the data names and their factors
 * @author Alik Balika
 * @version 2020.11.04
 */
public enum Size {

    BIT(1, "b"), KILOBIT(1_000, "kb"), MEGABIT(1_000_000, "mb"),
    GIGABIT(1_000_000_000L, "gb"), TERABIT(1_000_000_000_000L, "tb"), BYTE(8, "B"),
    KILOBYTE(8_000, "KB"), MEGABYTE(8_000_000, "MB"), GIGABYTE(8_000_000_000L, "GB"),
    TERABYTE(8_000_000_000_000L, "TB");

    private final long factor;
    private final String name;

    Size(long factor, String name) {
        this.factor = factor;
        this.name = name;
    }

    public long getFactor() {
        return factor;
    }

    public String getName() {
        return name;
    }
}
