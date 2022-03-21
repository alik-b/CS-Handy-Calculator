package com.alikbCalculator.controller;

import com.alikbCalculator.model.RateUnit;
import com.alikbCalculator.model.SizeUnit;
import com.alikbCalculator.view.MainCLI;

/**
 * Class that deals with converting units to other kinds of units.
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class Converter {

    /**
     * Takes in a SizeUnit object and converts that SizeUnit to all other SizeUnit objects.
     *
     * @param sizeUnit The unit that is going to be converted
     * @return a string containing the conversions to all the other SizeUnit objects
     */
    public static String convertDataUnit(SizeUnit sizeUnit) {

        return sizeUnit.getValue() + " " + sizeUnit.getUnit().getName() +
                " is equivalent to any of the following: \n" +
                String.format("%.3g bits (b)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor()) +
                String.format("%.3g kilobits (kb)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 1_000) +
                String.format("%.3g megabits (mb)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 1_000_000) +
                String.format("%.3g gigabits (kb)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 1_000_000_000L) +
                String.format("%.3g terabits (kb)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 1_000_000_000_000L) +
                String.format("%.3g Bytes (B)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 8) +
                String.format("%.3g Kilobytes (KB)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 8_000) +
                String.format("%.3g Megabytes (MB)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 8_000_000) +
                String.format("%.3g Gigabytes (GB)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 8_000_000_000L) +
                String.format("%.3g Terabytes (TB)\n", sizeUnit.getValue() * sizeUnit.getUnit().getFactor() / 8_000_000_000_000L);
    }

    /**
     * Takes in a SizeUnit and a RateUnit object and if the value in SizeUnit is 0, Then it converts from
     * the specified RateUnit per second to the specified SizeUnit per month. If the value in RateUnit is 0, then it
     * converts from the specified SizeUnit per month to the specified RateUnit per second. If one of the values
     * is not a zero, then it will display an error message.
     *
     * @param sizeUnit The unit that will be converted to RateUnit if the value in RateUnit is 0
     * @param rateUnit The unit that wll be converted to SizeUnit if the value in SizeUnit is 0.
     * @return A string containing the conversion from SizeUnit to RateUnit or vice versa or an error message otherwise.
     */
    public static String convertHostingBandwidth(SizeUnit sizeUnit, RateUnit rateUnit) {
        if (rateUnit.getValue() == 0) {

            double megaByte = sizeUnit.getValue() * (sizeUnit.getUnit().getFactor() / 8.0) / 1_000_000;

            megaByte = switch (rateUnit.getUnit()) {
                case BITpS -> megaByte * 3.0420564301468;
                case KBITpS -> megaByte * 0.0030420564301468;
                case MBITpS -> megaByte * 3.0420564301468E-6;
                case GBITpS -> megaByte * 3.0420564301468E-9;
                case TBITpS -> megaByte * 3.0420564301468E-12;
            };

            return sizeUnit.getValue() + " " + sizeUnit.getUnit().getName() + "/month is equivalent to " + String.format("%.3g ", megaByte) +
                    rateUnit.getUnit().getName();

        } else if (sizeUnit.getValue() == 0) {
            double megaBitPerSec = rateUnit.getValue() * rateUnit.getUnit().getFactor() / 1_000_000;

            switch (sizeUnit.getUnit()) {
                case BYTE -> megaBitPerSec *= 328725000000L;
                case KILOBYTE -> megaBitPerSec *= 328725000;
                case MEGABYTE -> megaBitPerSec *= 328725;
                case GIGABYTE -> megaBitPerSec *= 328.725;
                case TERABYTE -> megaBitPerSec *= 0.328725;
            }

            return rateUnit.getValue() + " " + rateUnit.getUnit().getName() + " is equivalent to " + String.format("%.3g ", megaBitPerSec) +
                    sizeUnit.getUnit().getName() + "/month";

        } else {
            return MainCLI.ANSI_RED + "One of the values must equal zero!" + MainCLI.ANSI_RESET;
        }
    }


}
