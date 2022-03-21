package com.alikbCalculator.controller;

/**
 * Interface that holds methods for converting between binary hex and decimal
 * @author Alik Balika
 * @version 2020.11.04
 */
public interface Convertible {
    String toBinary();
    String toHex();
    long toDecimal();
}
