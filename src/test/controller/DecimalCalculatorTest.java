package test.controller;

import com.alikbCalculator.controller.DecimalCalculator;
import com.alikbCalculator.model.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalCalculatorTest {

    @Test
    void add() {
        DecimalCalculator dc = new DecimalCalculator();
        Decimal d1 = new Decimal(5000);
        Decimal d2 = new Decimal(2500);
        assertEquals(7500, dc.add(d1, d2).toDecimal());

        d1.setValue("50750");
        d2.setValue("5150");
        assertEquals(55900, dc.add(d1, d2).toDecimal());
    }

    @Test
    void subtract() {
        DecimalCalculator dc = new DecimalCalculator();
        Decimal d1 = new Decimal(450);
        Decimal d2 = new Decimal(50);
        assertEquals(400, dc.subtract(d1, d2).toDecimal());

        d1.setValue("600");
        d2.setValue("600");
        assertEquals(0, dc.subtract(d1, d2).toDecimal());
    }

    @Test
    void multiply() {
        DecimalCalculator dc = new DecimalCalculator();
        Decimal d1 = new Decimal(200);
        Decimal d2 = new Decimal(5);
        assertEquals(1000, dc.multiply(d1, d2).toDecimal());

        d1.setValue("800");
        d2.setValue("900");
        assertEquals(720000, dc.multiply(d1, d2).toDecimal());
    }

    @Test
    void divide() {
        DecimalCalculator dc = new DecimalCalculator();
        Decimal d1 = new Decimal(845);
        Decimal d2 = new Decimal(80);
        assertEquals("10 Remainder: 45", dc.divide(d1, d2));

        d1.setValue("650");
        d2.setValue("0");
        assertThrows(ArithmeticException.class, () -> dc.divide(d1, d2));
    }
}