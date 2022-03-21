package test.model;

import com.alikbCalculator.model.Rate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateTest {

    @Test
    void getFactor() {
        assertEquals(1, Rate.BITpS.getFactor());
        assertEquals(1_000, Rate.KBITpS.getFactor());
        assertEquals(1_000_000, Rate.MBITpS.getFactor());
        assertEquals(1_000_000_000, Rate.GBITpS.getFactor());
        assertEquals(1_000_000_000_000L, Rate.TBITpS.getFactor());
    }

    @Test
    void getName() {
        assertEquals("bit/s", Rate.BITpS.getName());
        assertEquals("Kbit/s", Rate.KBITpS.getName());
        assertEquals("Mbit/s", Rate.MBITpS.getName());
        assertEquals("Gbit/s", Rate.GBITpS.getName());
        assertEquals("Tbit/s", Rate.TBITpS.getName());
    }
}