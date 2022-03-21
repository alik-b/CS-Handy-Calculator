package test.controller;

import com.alikbCalculator.controller.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isOperator() {
        assertFalse(Utils.isOperator("+"));
        assertFalse(Utils.isOperator("-"));
        assertFalse(Utils.isOperator("*"));
        assertFalse(Utils.isOperator("/"));
        assertTrue(Utils.isOperator("q"));
        assertTrue(Utils.isOperator("y"));
        assertTrue(Utils.isOperator("%"));
    }

    @Test
    void isInteger() {
        assertTrue(Utils.isInteger("1234"));
        assertTrue(Utils.isInteger("242"));
        assertTrue(Utils.isInteger("5"));
        assertTrue(Utils.isInteger("11123"));
        assertFalse(Utils.isInteger("fgf"));
        assertFalse(Utils.isInteger("-123123"));
        assertFalse(Utils.isInteger("!@#$"));
    }

    @Test
    void isHex() {
        assertTrue(Utils.isHex("FFFFFFFFFFFFFFF"));
        assertTrue(Utils.isHex("ABCDEF"));
        assertTrue(Utils.isHex("123456789abcdef"));
        assertTrue(Utils.isHex("1023ccde"));
        assertFalse(Utils.isHex("-1231213"));
        assertFalse(Utils.isHex("TTYYZZ"));
        assertFalse(Utils.isHex("#$%^"));
        assertFalse(Utils.isHex("abcdefg"));
    }

    @Test
    void isBinary() {
        assertTrue(Utils.isBinary("1111111111111111111111111111111111111111111111111111111111111"));
        assertTrue(Utils.isBinary("1010100101001010"));
        assertTrue(Utils.isBinary("0"));
        assertTrue(Utils.isBinary("101010010101111111111111000000000011111111"));
        assertFalse(Utils.isBinary("-11010101"));
        assertFalse(Utils.isBinary("10110100510101001"));
        assertFalse(Utils.isBinary("01010n10101"));
        assertFalse(Utils.isBinary("hhh44747101"));
    }

    @Test
    void isValidTimeUnits() {
        assertFalse(Utils.isValidTimeUnits("persecond"));
        assertFalse(Utils.isValidTimeUnits("perminute"));
        assertFalse(Utils.isValidTimeUnits("perhour"));
        assertFalse(Utils.isValidTimeUnits("perday"));
        assertFalse(Utils.isValidTimeUnits("perweek"));
        assertFalse(Utils.isValidTimeUnits("permonth"));
        assertFalse(Utils.isValidTimeUnits("peryear"));
        assertFalse(Utils.isValidTimeUnits("per second"));
        assertFalse(Utils.isValidTimeUnits("per minute"));
        assertFalse(Utils.isValidTimeUnits("per hour"));
        assertFalse(Utils.isValidTimeUnits("per day"));
        assertFalse(Utils.isValidTimeUnits("per week"));
        assertFalse(Utils.isValidTimeUnits("per month"));
        assertFalse(Utils.isValidTimeUnits("per year"));
        assertTrue(Utils.isValidTimeUnits("1231"));
        assertTrue(Utils.isValidTimeUnits("peryeat"));
        assertTrue(Utils.isValidTimeUnits("lmnop"));
        assertTrue(Utils.isValidTimeUnits("qwertyuiop"));
        assertTrue(Utils.isValidTimeUnits("persevond"));
        assertTrue(Utils.isValidTimeUnits("mmmm"));

    }

    @Test
    void isValidAllKeyword() {
        assertFalse(Utils.isValidAllKeyword("bits"));
        assertFalse(Utils.isValidAllKeyword("kilobits"));
        assertFalse(Utils.isValidAllKeyword("megabits"));
        assertFalse(Utils.isValidAllKeyword("gigabits"));
        assertFalse(Utils.isValidAllKeyword("terabits"));
        assertFalse(Utils.isValidAllKeyword("bytes"));
        assertFalse(Utils.isValidAllKeyword("kilobytes"));
        assertFalse(Utils.isValidAllKeyword("megabytes"));
        assertFalse(Utils.isValidAllKeyword("gigabytes"));
        assertFalse(Utils.isValidAllKeyword("terabytes"));
        assertTrue(Utils.isValidAllKeyword("123141"));
        assertTrue(Utils.isValidAllKeyword("bitss"));
        assertTrue(Utils.isValidAllKeyword("kilobites"));
        assertTrue(Utils.isValidAllKeyword("teraabits"));
        assertTrue(Utils.isValidAllKeyword("!@#%$@!"));
    }

    @Test
    void isValidBottomKeywords() {
        assertFalse(Utils.isValidBottomKeywords("bytes"));
        assertFalse(Utils.isValidBottomKeywords("kilobytes"));
        assertFalse(Utils.isValidBottomKeywords("megabytes"));
        assertFalse(Utils.isValidBottomKeywords("gigabytes"));
        assertFalse(Utils.isValidBottomKeywords("terabytes"));
        assertTrue(Utils.isValidBottomKeywords("123141"));
        assertTrue(Utils.isValidBottomKeywords("bitss"));
        assertTrue(Utils.isValidBottomKeywords("kilobites"));
        assertTrue(Utils.isValidBottomKeywords("teraabits"));
        assertTrue(Utils.isValidBottomKeywords("!@#%$@!"));
    }

    @Test
    void isValidUnitPerTimeKeywords() {
        assertFalse(Utils.isValidUnitPerTimeKeywords("bit/s"));
        assertFalse(Utils.isValidUnitPerTimeKeywords("kbit/s"));
        assertFalse(Utils.isValidUnitPerTimeKeywords("mbit/s"));
        assertFalse(Utils.isValidUnitPerTimeKeywords("gbit/s"));
        assertFalse(Utils.isValidUnitPerTimeKeywords("tbit/s"));
        assertTrue(Utils.isValidUnitPerTimeKeywords("1234123"));
        assertTrue(Utils.isValidUnitPerTimeKeywords("bit/ss"));
        assertTrue(Utils.isValidUnitPerTimeKeywords("kit/s"));
        assertTrue(Utils.isValidUnitPerTimeKeywords("!@!!!1"));
    }
}