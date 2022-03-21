package test.controller;

import com.alikbCalculator.controller.BinaryCalculator;
import com.alikbCalculator.model.Binary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    @Test
    void add() {
        BinaryCalculator bc = new BinaryCalculator();
        Binary b1 = new Binary("10101010");
        Binary b2 = new Binary("11001100");
        assertEquals("101110110", bc.add(b1, b2).toString());

        b1.setValue("111111");
        b2.setValue("1011010");
        assertEquals("10011001", bc.add(b1, b2).toString());
    }

    @Test
    void subtract() {
        BinaryCalculator bc = new BinaryCalculator();
        Binary b1 = new Binary("10101010");
        Binary b2 = new Binary("11001100");
        assertEquals("-100010", bc.subtract(b1, b2).toString());

        b1.setValue("111111111");
        b2.setValue("10101");
        assertEquals("111101010", bc.subtract(b1, b2).toString());
    }

    @Test
    void multiply() {
        BinaryCalculator bc = new BinaryCalculator();
        Binary b1 = new Binary("10101010");
        Binary b2 = new Binary("11001100");
        assertEquals("1000011101111000", bc.multiply(b1, b2).toString());

        b1.setValue("1010101");
        b2.setValue("111");
        assertEquals("1001010011", bc.multiply(b1, b2).toString());
    }

    @Test
    void divide() {
        BinaryCalculator bc = new BinaryCalculator();
        Binary b1 = new Binary("10101010");
        Binary b2 = new Binary("11001100");
        assertEquals("Binary Value: 0 Remainder: 10101010     Decimal Value: 0 Remainder: 170", bc.divide(b1, b2));

        b1.setValue("1010101");
        b2.setValue("0");
        assertThrows(ArithmeticException.class, () -> bc.divide(b1, b2));

    }
}