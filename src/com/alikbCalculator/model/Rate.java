package com.alikbCalculator.model;

/**
 * enum that holds the rate names and their factors
 * @author Alik Balika
 * @version 2020.11.04
 */
public enum Rate {

    BITpS(1, "bit/s"), KBITpS(1_000, "Kbit/s"), MBITpS(1_000_000, "Mbit/s"),
    GBITpS(1_000_000_000, "Gbit/s"), TBITpS(1_000_000_000_000L, "Tbit/s");

    long factor;
    String name;

    Rate(long factor, String name) {
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
