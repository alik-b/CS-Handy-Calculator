package test.controller;

import com.alikbCalculator.controller.Converter;
import com.alikbCalculator.model.Rate;
import com.alikbCalculator.model.RateUnit;
import com.alikbCalculator.model.Size;
import com.alikbCalculator.model.SizeUnit;
import com.alikbCalculator.view.MainCLI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void convertDataUnit() {
        SizeUnit sizeUnit = new SizeUnit(Size.BIT, 50);
        assertEquals("50.0 b is equivalent to any of the following: \n" +
                "50.0 bits (b)\n" +
                "0.0500 kilobits (kb)\n" +
                "5.00e-05 megabits (mb)\n" +
                "5.00e-08 gigabits (kb)\n" +
                "5.00e-11 terabits (kb)\n" +
                "6.25 Bytes (B)\n" +
                "0.00625 Kilobytes (KB)\n" +
                "6.25e-06 Megabytes (MB)\n" +
                "6.25e-09 Gigabytes (GB)\n" +
                "6.25e-12 Terabytes (TB)\n", Converter.convertDataUnit(sizeUnit));

        sizeUnit.setUnit(Size.BYTE);
        assertEquals("50.0 B is equivalent to any of the following: \n" +
                "400 bits (b)\n" +
                "0.400 kilobits (kb)\n" +
                "0.000400 megabits (mb)\n" +
                "4.00e-07 gigabits (kb)\n" +
                "4.00e-10 terabits (kb)\n" +
                "50.0 Bytes (B)\n" +
                "0.0500 Kilobytes (KB)\n" +
                "5.00e-05 Megabytes (MB)\n" +
                "5.00e-08 Gigabytes (GB)\n" +
                "5.00e-11 Terabytes (TB)\n", Converter.convertDataUnit(sizeUnit));

        // other Size values are along the same lines...
    }

    @Test
    void convertHostingBandwidth() {
        SizeUnit sizeUnit = new SizeUnit(Size.MEGABYTE, 150);
        RateUnit rateUnit = new RateUnit(Rate.KBITpS, 0);
        assertEquals("150.0 MB/month is equivalent to 0.456 Kbit/s", Converter.convertHostingBandwidth(sizeUnit, rateUnit));

        sizeUnit.setValue(0);
        rateUnit.setValue(500);
        assertEquals("500.0 Kbit/s is equivalent to 1.64e+05 MB/month", Converter.convertHostingBandwidth(sizeUnit, rateUnit));

        sizeUnit.setValue(45);
        rateUnit.setValue(500);
        assertEquals(MainCLI.ANSI_RED + "One of the values must equal zero!" + MainCLI.ANSI_RESET, Converter.convertHostingBandwidth(sizeUnit, rateUnit));

    }
}