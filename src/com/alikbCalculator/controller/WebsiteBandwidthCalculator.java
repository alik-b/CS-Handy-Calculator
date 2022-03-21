package com.alikbCalculator.controller;

import com.alikbCalculator.model.FrequencyUnit;
import com.alikbCalculator.model.SizeUnit;

/**
 * Class that deals with calculating the website bandwidth
 * @author Alik Balika
 * @version 2020.11.04
 */
public class WebsiteBandwidthCalculator {

    /**
     * Takes in 3 parameters, one of SizeUnit which contains the average page size, one of FrequencyUnit which
     * contains the page views per some time frame and one of double which is the redundancy. It then calculates the
     * bandwidth needed for the website and the redundancy factor.
     *
     * @param sizeUnit SizeUnit object containing the average page size
     * @param frequencyUnit FrequencyUnit object containing the pageViews
     * @param redundancy double that specifies the redundancy
     * @return a new String that contains the bandwidth needed for that website
     */
    public static String calculate(SizeUnit sizeUnit, FrequencyUnit frequencyUnit, double redundancy) {

        double pageViews = frequencyUnit.getValue() * frequencyUnit.getUnit().getFactor();
        double pageSize = sizeUnit.getValue() * (sizeUnit.getUnit().getFactor() / 8.0) / 1_000_000_000;

        double bandwidthInGB = pageViews * pageSize;
        double bandwidthInMbits = bandwidthInGB / 329;

        return String.format("<html>Actual bandwidth needed is %.3g  Mbits/s or %.3g GB per month.<br/>" +
                "With redundancy factor of %.1f , the bandwidth needed is %.3g Mbit/s or %.3g GB per month.<html>" ,
                bandwidthInMbits, bandwidthInGB, redundancy, (bandwidthInMbits * redundancy), (bandwidthInGB * redundancy));
    }

}
