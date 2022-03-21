package test.model;

import com.alikbCalculator.model.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalTest {

    @Test
    void setValueAndGetValue() {
        Decimal d = new Decimal(5000);
        assertEquals("5000", d.getValue());

        d.setValue("123456789");
        assertEquals("123456789", d.getValue());

        d.setValue("-554");
        assertEquals("-554", d.getValue());

        d.setValue("0");
        assertEquals("0", d.getValue());

        d.setValue("abcdef");
        assertNotEquals("abcdef", d.getValue());

        d.setValue("!!!!!");
        assertNotEquals("!!!!!", d.getValue());
    }

    @Test
    void toBinary() {
        Decimal d = new Decimal(10546);
        assertEquals("10100100110010", d.toBinary());

        d.setValue("-546");
        assertEquals("-1000100010", d.toBinary());

        d.setValue("0");
        assertEquals("0", d.toBinary());
    }

    @Test
    void toHex() {
        Decimal d = new Decimal(3678);
        assertEquals("E5E", d.toHex());

        d.setValue("-25999");
        assertEquals("-658F", d.toHex());

        d.setValue("0");
        assertEquals("0", d.toHex());
    }

    @Test
    void toDecimal() {
        Decimal d = new Decimal(500);
        assertEquals(500, d.toDecimal());

        d.setValue("-400");
        assertEquals(-400, d.toDecimal());

        d.setValue("0");
        assertEquals(0, d.toDecimal());
    }
}