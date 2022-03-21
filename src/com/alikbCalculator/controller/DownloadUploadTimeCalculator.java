package com.alikbCalculator.controller;

import com.alikbCalculator.model.RateUnit;
import com.alikbCalculator.model.SizeUnit;

/**
 * Class that deals with the download and upload time of SizeUnit and RateUnit
 * @author Alik Balika
 * @version 2020.11.04
 */
public class DownloadUploadTimeCalculator {

    /**
     * Takes in 2 parameters, one of SizeUnit which contains the amount of data that there is and one of RateUnit
     * which contains the bandwidth. It does the necessary calculations to display the download/upload time in the form
     * of # days, # hour, # minutes, # seconds.
     *
     * @param sizeUnit SizeUnit object that contains how much data to download/upload
     * @param rateUnit RateUnit object containing the bandwidth
     * @return a new String containing what the download/upload time is
     */
    public static String calculate(SizeUnit sizeUnit, RateUnit rateUnit) {

        double megaByte = sizeUnit.getValue() * (sizeUnit.getUnit().getFactor() / 8.0) / 1_000_000;
        double megaBitPerSec = rateUnit.getValue() * rateUnit.getUnit().getFactor() / 1_000_000;

        double totalSeconds = megaByte / (megaBitPerSec / 8);
        double days = (totalSeconds / 86400);
        totalSeconds %= 86400;
        int hours = (int) (totalSeconds / 3600);
        totalSeconds %= 3600;
        int minutes = (int) (totalSeconds / 60);
        totalSeconds %= 60;

        return String.format("%.1f days, " + hours + " hours, " + minutes + " minutes, " + "%.3g" +
                " seconds", days, totalSeconds);
    }
}
