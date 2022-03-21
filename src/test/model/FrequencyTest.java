package test.model;

import com.alikbCalculator.model.Frequency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyTest {

    @Test
    void getFactor() {
        assertEquals(2_629_800.0, Frequency.SECOND.getFactor());
        assertEquals(43_830.0, Frequency.MINUTE.getFactor());
        assertEquals(730.5, Frequency.HOUR.getFactor());
        assertEquals(30.4375, Frequency.DAY.getFactor());
        assertEquals(4.3482142857143, Frequency.WEEK.getFactor());
        assertEquals(1.0, Frequency.MONTH.getFactor());
        assertEquals(0.083333333333333, Frequency.YEAR.getFactor());
    }
}