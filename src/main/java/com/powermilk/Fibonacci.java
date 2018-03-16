package com.powermilk;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fibonacci {
    public static BigInteger calculateFibonacciNumber(int number) {
        if(number < 1) {
            ArithmeticException exception = new ArithmeticException("The number should be more than 0");
            throw exception;
        }

        if(number == 1 || number == 2) {
            return BigInteger.ONE;
        }

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ZERO;

        for (int i = 3; i <= number; i++) {
            fibonacci = n1.add(n2);
            n1 = n2;
            n2 = fibonacci;
        }

        return fibonacci;
    }

    public static String printFibonacciSeries(int number) {
        return IntStream
                .rangeClosed(1, number)
                .boxed()
                .map(i -> calculateFibonacciNumber(i))
                .map(BigInteger::toString)
                .collect(Collectors.joining(", "));
    }
}
