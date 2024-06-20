package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void testUnknownAmountOfNumbers() {
        assertEquals(6, calculator.Add("1,2,3"));
    }

    @Test
    public void testNewLinesBetweenNumbers() {
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiters() {
        assertEquals(3, calculator.Add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.Add("1,-2,3"));
        assertEquals("Negatives not allowed: [-2]", exception.getMessage());
    }

    @Test
    public void testMultipleNegativeNumbers() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.Add("1,-2,-3"));
        assertEquals("Negatives not allowed: [-2, -3]", exception.getMessage());
    }

    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        assertEquals(2, calculator.Add("2,1001"));
    }

    @Test
    public void testDelimitersOfAnyLength() {
        assertEquals(6, calculator.Add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimiters() {
        assertEquals(6, calculator.Add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleDelimitersWithLengthLongerThanOneChar() {
        assertEquals(6, calculator.Add("//[**][%%]\n1**2%%3"));
    }
}