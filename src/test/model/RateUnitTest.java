package test.model;

import com.alikbCalculator.model.Rate;
import com.alikbCalculator.model.RateUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateUnitTest {

    @Test
    void setUnitAndGetUnit() {
        RateUnit r = new RateUnit(Rate.BITpS, 0);
        r.setUnit(Rate.BITpS);
        assertEquals(Rate.BITpS, r.getUnit());
        r.setUnit(Rate.KBITpS);
        assertEquals(Rate.KBITpS, r.getUnit());
        r.setUnit(Rate.MBITpS);
        assertEquals(Rate.MBITpS, r.getUnit());
        r.setUnit(Rate.GBITpS);
        assertEquals(Rate.GBITpS, r.getUnit());
        r.setUnit(Rate.TBITpS);
        assertEquals(Rate.TBITpS, r.getUnit());
    }

    @Test
    void setValueAndGetValue() {
        RateUnit r = new RateUnit(Rate.BITpS, 0);
        r.setValue(500.5);
        assertEquals(500.5, r.getValue());
        r.setValue(0);
        assertEquals(0, r.getValue());

        r.setValue(-50);
        assertNotEquals(-50, r.getValue());
    }

    @Test
    void intChooser() {
        assertEquals(Rate.BITpS, RateUnit.intChooser(0));
        assertEquals(Rate.KBITpS, RateUnit.intChooser(1));
        assertEquals(Rate.MBITpS, RateUnit.intChooser(2));
        assertEquals(Rate.GBITpS, RateUnit.intChooser(3));
        assertEquals(Rate.TBITpS, RateUnit.intChooser(4));
    }
}