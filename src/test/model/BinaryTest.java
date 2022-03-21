package test.model;

import com.alikbCalculator.model.Binary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @Test
    void setValueAndGetValue() {
        Binary b = new Binary("0");
        b.setValue("111");
        assertEquals("111", b.getValue());

        b.setValue("1010101");
        assertEquals("1010101", b.getValue());

        b.setValue("-1111111");
        assertNotEquals("-1111111", b.getValue());

        b.setValue("123456789");
        assertNotEquals("123456789", b.getValue());

        b.setValue("abcdefg");
        assertNotEquals("abcdefg", b.getValue());
    }

    @Test
    void toBinary() {
        Binary b = new Binary("111");
        assertEquals("111", b.toBinary());

        b.setValue("101010");
        assertEquals("101010", b.toBinary());

        b.setValue("0");
        assertEquals("0", b.toBinary());

        b.setValue("werqw");
        assertNotEquals("werqw", b.toBinary());
    }

    @Test
    void toHex() {
        Binary b = new Binary("101010");
        assertEquals("2A", b.toHex());

        b.setValue("11111");
        assertEquals("1F", b.toHex());

        b.setValue("101010101010101010101010");
        assertEquals("AAAAAA", b.toHex());

        b.setValue("0");
        assertEquals("0", b.toHex());
    }

    @Test
    void toDecimal() {
        Binary b = new Binary("10000");
        assertEquals(16, b.toDecimal());

        b.setValue("11111111111111111");
        assertEquals(131071, b.toDecimal());

        b.setValue("0000001");
        assertEquals(1, b.toDecimal());

        b.setValue("0");
        assertEquals(0, b.toDecimal());
    }
}