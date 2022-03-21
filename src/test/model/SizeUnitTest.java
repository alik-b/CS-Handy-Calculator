package test.model;

import com.alikbCalculator.model.Size;
import com.alikbCalculator.model.SizeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeUnitTest {

    @Test
    void intChooserDataUnitConverter() {
        assertEquals(Size.BIT, SizeUnit.intChooserDataUnitConverter(0));
        assertEquals(Size.KILOBIT, SizeUnit.intChooserDataUnitConverter(1));
        assertEquals(Size.MEGABIT, SizeUnit.intChooserDataUnitConverter(2));
        assertEquals(Size.GIGABIT, SizeUnit.intChooserDataUnitConverter(3));
        assertEquals(Size.TERABIT, SizeUnit.intChooserDataUnitConverter(4));
        assertEquals(Size.BYTE, SizeUnit.intChooserDataUnitConverter(5));
        assertEquals(Size.KILOBYTE, SizeUnit.intChooserDataUnitConverter(6));
        assertEquals(Size.MEGABYTE, SizeUnit.intChooserDataUnitConverter(7));
        assertEquals(Size.GIGABYTE, SizeUnit.intChooserDataUnitConverter(8));
        assertEquals(Size.TERABYTE, SizeUnit.intChooserDataUnitConverter(9));
    }

    @Test
    void intChooserOther() {
        assertEquals(Size.BYTE, SizeUnit.intChooserOther(0));
        assertEquals(Size.KILOBYTE, SizeUnit.intChooserOther(1));
        assertEquals(Size.MEGABYTE, SizeUnit.intChooserOther(2));
        assertEquals(Size.GIGABYTE, SizeUnit.intChooserOther(3));
        assertEquals(Size.TERABYTE, SizeUnit.intChooserOther(4));
    }

    @Test
    void setUnitAndGetUnit() {
        SizeUnit s = new SizeUnit(Size.BIT, 0);
        s.setUnit(Size.BIT);
        assertEquals(Size.BIT, s.getUnit());
        s.setUnit(Size.KILOBIT);
        assertEquals(Size.KILOBIT, s.getUnit());
        s.setUnit(Size.MEGABIT);
        assertEquals(Size.MEGABIT, s.getUnit());
        s.setUnit(Size.GIGABIT);
        assertEquals(Size.GIGABIT, s.getUnit());
        s.setUnit(Size.TERABIT);
        assertEquals(Size.TERABIT, s.getUnit());
        s.setUnit(Size.BYTE);
        assertEquals(Size.BYTE, s.getUnit());
        s.setUnit(Size.KILOBYTE);
        assertEquals(Size.KILOBYTE, s.getUnit());
        s.setUnit(Size.MEGABYTE);
        assertEquals(Size.MEGABYTE, s.getUnit());
        s.setUnit(Size.GIGABYTE);
        assertEquals(Size.GIGABYTE, s.getUnit());
        s.setUnit(Size.TERABYTE);
        assertEquals(Size.TERABYTE, s.getUnit());
    }

    @Test
    void setValueAndGetValue() {
        SizeUnit s = new SizeUnit(Size.BIT, 0);
        s.setValue(580.5);
        assertEquals(580.5, s.getValue());
        s.setValue(0);
        assertEquals(0, s.getValue());

        s.setValue(-50);
        assertNotEquals(-50, s.getValue());
    }
}