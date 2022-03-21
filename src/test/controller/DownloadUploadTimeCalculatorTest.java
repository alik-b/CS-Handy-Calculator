package test.controller;

import com.alikbCalculator.controller.DownloadUploadTimeCalculator;
import com.alikbCalculator.model.Rate;
import com.alikbCalculator.model.RateUnit;
import com.alikbCalculator.model.Size;
import com.alikbCalculator.model.SizeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DownloadUploadTimeCalculatorTest {

    @Test
    void calculate() {
        SizeUnit sizeUnit = new SizeUnit(Size.TERABYTE, 75);
        RateUnit rateUnit = new RateUnit(Rate.MBITpS, 500);
        assertEquals("13.9 days, 21 hours, 20 minutes, 0.00 seconds", DownloadUploadTimeCalculator.calculate(sizeUnit, rateUnit));

        sizeUnit.setUnit(Size.BIT);
        sizeUnit.setValue(1);
        rateUnit.setUnit(Rate.TBITpS);
        rateUnit.setValue(100);
        assertEquals("0.0 days, 0 hours, 0 minutes, 1.00e-14 seconds", DownloadUploadTimeCalculator.calculate(sizeUnit, rateUnit));
    }
}