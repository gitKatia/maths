package com.kat.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void add() {

        // Given
        Complex complexA = new Complex(2, 3);
        Complex complexB = new Complex(2, -3);;

        // When
        Complex result = complexA.add(complexB);

        // Then
        assertEquals(4, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void subtract() {

        // Given
        Complex complexA = new Complex(2, 3);
        Complex complexB = new Complex(2, -3);;

        // When
        Complex result = complexA.subtract(complexB);

        // Then
        assertEquals(0, result.getReal());
        assertEquals(6, result.getImaginary());
    }

    @Test
    void multiply() {

        // Given
        Complex complexA = new Complex(2, 3);
        Complex complexB = new Complex(2, -3);

        // When
        Complex result = complexA.multiply(complexB);

        // Then
        assertEquals(13, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void multiplyByReal() {

        // Given
        Complex complexA = new Complex(2, 3);
        Complex complexB = new Complex(2, 0);

        // When
        Complex result = complexA.multiply(complexB);

        // Then
        assertEquals(4, result.getReal());
        assertEquals(6, result.getImaginary());
    }

    @Test
    void divideBy() {

        // Given
        Complex complexA = new Complex(2, -3);
        Complex complexB = new Complex(2, -3);;

        // When
        Complex result = complexA.divideBy(complexB);

        // Then
        assertEquals(1, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void divideByZero() {

        // Given
        Complex complexA = new Complex(2, -3);
        Complex complexB = new Complex(0, 0);;

        // When
        Complex result = complexA.divideBy(complexB);

        // Then
        assertTrue(Double.isInfinite(result.getReal()));
        assertTrue(Double.isInfinite(result.getImaginary()));
        assertEquals(Double.POSITIVE_INFINITY, result.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, result.getImaginary());
    }

    @Test
    void conjugate() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.conjugate();

        // Then
        assertEquals(2, result.getReal());
        assertEquals(-3, result.getImaginary());
    }

    @Test
    void multiplyByConjugated() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.multiplyByConjugated();

        // Then
        assertEquals(13, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void powerZero() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.power(0);

        // Then
        assertEquals(1, result.getReal());
        assertEquals(0, result.getImaginary());
    }

    @Test
    void powerOne() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.power(1);

        // Then
        assertEquals(2, result.getReal());
        assertEquals(+3, result.getImaginary());
    }

    @Test
    void powerTwo() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.power(2);

        // Then
        assertEquals(-5, result.getReal());
        assertEquals(12, result.getImaginary());
    }

    @Test
    void powerThree() {

        // Given
        Complex complexA = new Complex(2, +3);

        // When
        Complex result = complexA.power(3);

        // Then
        assertEquals(-46, result.getReal());
        assertEquals(9, result.getImaginary());
    }

    @Test
    void modulus() {

        // Given
        Complex complexA = new Complex(3, 4);

        // When
        double result = complexA.modulus();

        // Then
        assertEquals(5, result);
    }

    @Test
    void isZero() {

        // Given
        Complex complexA = new Complex(3, 4);

        // When
        boolean result = complexA.isZero();

        // Then
        assertFalse(result);
    }

    @Test
    void isZero_() {

        // Given
        Complex complexA = new Complex(0, 0);

        // When
        boolean result = complexA.isZero();

        // Then
        assertTrue(result);
    }
}
