package test.model;

import com.alikbCalculator.model.Hex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexTest {

    @Test
    void setValueAndGetValue() {
        Hex h = new Hex("0");
        h.setValue("FFFF");
        assertEquals("FFFF", h.getValue());

        h.setValue("123456789ABCDEF");
        assertEquals("123456789ABCDEF", h.getValue());

        h.setValue("1242141234");
        assertEquals("1242141234", h.getValue());

        h.setValue("ZZZZ");
        assertNotEquals("ZZZZ", h.getValue());

        h.setValue("!@#$%");
        assertNotEquals("!@#$%", h.getValue());
    }

    @Test
    void toBinary() {
        Hex h = new Hex("FFFF");
        assertEquals("1111111111111111", h.toBinary());

        h.setValue("123456789");
        assertEquals("100100011010001010110011110001001", h.toBinary());

        h.setValue("DAD");
        assertEquals("110110101101", h.toBinary());

        h.setValue("0");
        assertEquals("0", h.toBinary());
    }

    @Test
    void toHex() {
        Hex h = new Hex("ABCDEF");
        assertEquals("ABCDEF", h.toHex());

        h.setValue("123412341234");
        assertEquals("123412341234", h.toHex());

        h.setValue("02468ACE");
        assertEquals("02468ACE", h.toHex());

        h.setValue("0");
        assertEquals("0", h.toHex());

        h.setValue("ghijklmnop");
        assertNotEquals("ghijklmnop", h.toHex());
    }

    @Test
    void toDecimal() {
        Hex h = new Hex("7777777");
        assertEquals(125269879, h.toDecimal());

        h.setValue("FFFFFFFFFFFF");
        assertEquals(281474976710655L, h.toDecimal());

        h.setValue("0");
        assertEquals(0, h.toDecimal());
    }
}