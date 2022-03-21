package test.controller;

import com.alikbCalculator.controller.HexCalculator;
import com.alikbCalculator.model.Hex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HexCalculatorTest {

    @Test
    void add() {
        HexCalculator hc = new HexCalculator();
        Hex h1 = new Hex("8AB");
        Hex h2 = new Hex("B78");
        assertEquals("1423", hc.add(h1, h2).toString());

        h1.setValue("ABCDEF");
        h2.setValue("123456789");
        assertEquals("123F13578", hc.add(h1, h2).toString());
    }

    @Test
    void subtract() {
        HexCalculator hc = new HexCalculator();
        Hex h1 = new Hex("8AB");
        Hex h2 = new Hex("B78");
        assertEquals("-2CD", hc.subtract(h1, h2).toString());

        h1.setValue("DAD");
        h2.setValue("DAD");
        assertEquals("0", hc.subtract(h1, h2).toString());

    }

    @Test
    void multiply() {
        HexCalculator hc = new HexCalculator();
        Hex h1 = new Hex("8AB");
        Hex h2 = new Hex("B78");
        assertEquals("636928", hc.multiply(h1, h2).toString());

        h1.setValue("FEDCBA");
        h2.setValue("15");
        assertEquals("14E81B42", hc.multiply(h1, h2).toString());
    }

    @Test
    void divide() {
        HexCalculator hc = new HexCalculator();
        Hex h1 = new Hex("77797");
        Hex h2 = new Hex("20F");
        assertEquals("Hex Value: 3A0 Remainder: 137     Decimal Value: 928 Remainder: 311", hc.divide(h1, h2));

        h1.setValue("12341234");
        h2.setValue("0");
        assertThrows(ArithmeticException.class,() -> hc.divide(h1, h2));
    }
}