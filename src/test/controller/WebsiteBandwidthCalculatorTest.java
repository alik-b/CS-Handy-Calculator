package test.controller;

import com.alikbCalculator.controller.WebsiteBandwidthCalculator;
import com.alikbCalculator.model.Frequency;
import com.alikbCalculator.model.FrequencyUnit;
import com.alikbCalculator.model.Size;
import com.alikbCalculator.model.SizeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteBandwidthCalculatorTest {

    @Test
    void calculate() {
        SizeUnit sizeUnit = new SizeUnit(Size.GIGABYTE, 20);
        FrequencyUnit frequencyUnit = new FrequencyUnit(Frequency.HOUR, 50);
        assertEquals("<html>Actual bandwidth needed is 2.22e+03  Mbits/s or 7.31e+05 GB per month.<br/>With " +
                "redundancy factor of 5.0 , the bandwidth needed is 1.11e+04 Mbit/s or 3.65e+06 GB per month.<html>"
                , WebsiteBandwidthCalculator.calculate(sizeUnit, frequencyUnit, 5));

        sizeUnit.setUnit(Size.KILOBYTE);
        sizeUnit.setValue(10000);
        frequencyUnit.setUnit(Frequency.DAY);
        frequencyUnit.setValue(20);
        assertEquals("<html>Actual bandwidth needed is 0.0185  Mbits/s or 6.09 GB per month.<br/>With " +
                        "redundancy factor of 10.0 , the bandwidth needed is 0.185 Mbit/s or 60.9 GB per month.<html>"
                , WebsiteBandwidthCalculator.calculate(sizeUnit, frequencyUnit, 10));


    }
}