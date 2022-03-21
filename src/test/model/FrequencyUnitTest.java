package test.model;

import com.alikbCalculator.model.Frequency;
import com.alikbCalculator.model.FrequencyUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyUnitTest {

    @Test
    void setUnitAndGetUnit() {
        FrequencyUnit f = new FrequencyUnit(Frequency.SECOND, 0);
        f.setUnit(Frequency.SECOND);
        assertEquals(Frequency.SECOND, f.getUnit());
        f.setUnit(Frequency.MINUTE);
        assertEquals(Frequency.MINUTE, f.getUnit());
        f.setUnit(Frequency.HOUR);
        assertEquals(Frequency.HOUR, f.getUnit());
        f.setUnit(Frequency.DAY);
        assertEquals(Frequency.DAY, f.getUnit());
        f.setUnit(Frequency.WEEK);
        assertEquals(Frequency.WEEK, f.getUnit());
        f.setUnit(Frequency.MONTH);
        assertEquals(Frequency.MONTH, f.getUnit());
        f.setUnit(Frequency.YEAR);
        assertEquals(Frequency.YEAR, f.getUnit());
    }

    @Test
    void setValueAndGetValue() {
        FrequencyUnit f = new FrequencyUnit(Frequency.SECOND, 0);
        f.setValue(1500);
        assertEquals(1500, f.getValue());
        f.setValue(0);
        assertEquals(0, f.getValue());

        f.setValue(-600);
        assertNotEquals(-600, f.getValue());
    }

    @Test
    void intChooserWebsiteBandwidth() {
        assertEquals(Frequency.SECOND, FrequencyUnit.intChooserWebsiteBandwidth(0));
        assertEquals(Frequency.MINUTE, FrequencyUnit.intChooserWebsiteBandwidth(1));
        assertEquals(Frequency.HOUR, FrequencyUnit.intChooserWebsiteBandwidth(2));
        assertEquals(Frequency.DAY, FrequencyUnit.intChooserWebsiteBandwidth(3));
        assertEquals(Frequency.WEEK, FrequencyUnit.intChooserWebsiteBandwidth(4));
        assertEquals(Frequency.MONTH, FrequencyUnit.intChooserWebsiteBandwidth(5));
        assertEquals(Frequency.YEAR, FrequencyUnit.intChooserWebsiteBandwidth(6));

    }
}