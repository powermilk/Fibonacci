package com.powermilk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Fibonacci class")
@SelectPackages("com.powermilk")
class FibonacciTest {
    private static final Logger log = LoggerFactory.getLogger(FibonacciTest.class);

    @BeforeEach
    void init() {
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Calculate should throws ArithmeticException (negative number as input)")
    void shouldThrowsCalculatingArithmeticExceptionForNegative() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> Fibonacci.calculateFibonacciNumber(-1));
        assertEquals(exception.getMessage(), "The number should be bigger than 0");
        log.info("Test for calculate for negative as input passed!");
    }

    @Test
    @DisplayName("Calculate should throws ArithmeticException (0 as input)")
    void shouldThrowsCalculatingArithmeticExceptionForZeroAsInput() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> Fibonacci.calculateFibonacciNumber(0));
        assertEquals(exception.getMessage(), "The number should be bigger than 0");
        log.info("Test for calculate for 0 as input passed!");
    }

    @Test
    @DisplayName("Calculate should return 1 (1 as input)")
    void shouldPassCalculatingForOneAsInput() {
        BigInteger expected = BigInteger.ONE;
        BigInteger actual = Fibonacci.calculateFibonacciNumber(1);
        assertEquals(expected, actual);
        log.info("Test for calculate for 1 as input passed!");
    }

    @Test
    @DisplayName("Calculate should return 1 (2 as input)")
    void shouldPassCalculatingForTwoAsInput() {
        BigInteger expected = BigInteger.ONE;
        BigInteger actual = Fibonacci.calculateFibonacciNumber(2);
        assertEquals(expected, actual);
        log.info("Test for calculate for 2 as input passed!");
    }

    @Test
    @DisplayName("Calculate should passed (small number as output)")
    void shouldPassCalculatingSmallNumberAsOutput() {
        BigInteger expected = BigInteger.valueOf(8);
        BigInteger actual = Fibonacci.calculateFibonacciNumber(6);
        assertEquals(expected, actual);
        log.info("Test for calculate small series passed!");
    }

    @Test
    @DisplayName("Calculate should passed (big number as output)")
    void shouldPassCalculatingBigNumberAsOutput() {
        BigInteger expected = BigInteger.valueOf(10610209857723L);
        BigInteger actual = Fibonacci.calculateFibonacciNumber(64);
        assertEquals(expected, actual);
        log.info("Test for calculate big series passed!");
    }

    @Test
    @DisplayName("Printing should returns empty string (negative number as input)")
    void shouldThrowsPrintingEmptyStringForNegative() {
        String expected = "";
        String actual = Fibonacci.printFibonacciSeries(-1);
        assertEquals(expected, actual);
        log.info("Test for printing empty string for negative passed!");

    }

    @Test
    @DisplayName("Printing should returns empty string (0 as input)")
    void shouldThrowsPrintingEmptyStringForZeroAsInput() {
        String expected = "";
        String actual = Fibonacci.printFibonacciSeries(0);
        assertEquals(expected, actual);
        log.info("Test for printing empty string for 0 passed!");
    }

    @Test
    @DisplayName("Printing should passed (1 as input)")
    void shouldPassPrintingForOneAsInput() {
        String expected = "1";
        String actual = Fibonacci.printFibonacciSeries(1);
        assertEquals(expected, actual);
        log.info("Test for printing string for 1 as input passed!");
    }

    @Test
    @DisplayName("Printing should passed (2 as input)")
    void shouldPassPrintingForTwoAsInput() {
        String expected = "1, 1";
        String actual = Fibonacci.printFibonacciSeries(2);
        assertEquals(expected, actual);
        log.info("Test for printing string for 2 as input passed!");
    }

    @Test
    @DisplayName("Printing should passed (short string as output)")
    void shouldPassPrintingShortStringAsOutput() {
        String expected = "1, 1, 2, 3, 5, 8";
        String actual = Fibonacci.printFibonacciSeries(6);
        assertEquals(expected, actual);
        log.info("Test for printing short string passed!");
    }

    @Test
    @DisplayName("Printing should passed (long string as output)")
    void shouldPassPrintingLongStringAsOutput() {
        String expected = "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144";
        String actual = Fibonacci.printFibonacciSeries(12);
        assertEquals(expected, actual);
        log.info("Test for printing long string passed!");
    }
}