package test.model;

import com.alikbCalculator.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeTest {

    @Test
    void getFactor() {
        assertEquals(1, Size.BIT.getFactor());
        assertEquals(1_000, Size.KILOBIT.getFactor());
        assertEquals(1_000_000, Size.MEGABIT.getFactor());
        assertEquals(1_000_000_000, Size.GIGABIT.getFactor());
        assertEquals(1_000_000_000_000L, Size.TERABIT.getFactor());
        assertEquals(8, Size.BYTE.getFactor());
        assertEquals(8_000, Size.KILOBYTE.getFactor());
        assertEquals(8_000_000, Size.MEGABYTE.getFactor());
        assertEquals(8_000_000_000L, Size.GIGABYTE.getFactor());
        assertEquals(8_000_000_000_000L, Size.TERABYTE.getFactor());
    }

    @Test
    void getName() {
        assertEquals("b", Size.BIT.getName());
        assertEquals("kb", Size.KILOBIT.getName());
        assertEquals("mb", Size.MEGABIT.getName());
        assertEquals("gb", Size.GIGABIT.getName());
        assertEquals("tb", Size.TERABIT.getName());
        assertEquals("B", Size.BYTE.getName());
        assertEquals("KB", Size.KILOBYTE.getName());
        assertEquals("MB", Size.MEGABYTE.getName());
        assertEquals("GB", Size.GIGABYTE.getName());
        assertEquals("TB", Size.TERABYTE.getName());
    }
}