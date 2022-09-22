package com.kat.maths;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Complex {
    private final double real;
    private final double imaginary;

    public Complex add(Complex other) {
        double real = this.real + other.real;
        double imaginary = this.imaginary + other.imaginary;
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex other) {
        double real = this.real - other.real;
        double imaginary = this.imaginary - other.imaginary;
        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex other) {
        double real = this.real * other.real - this.imaginary * other.imaginary;
        double imaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(real, imaginary);
    }

    public Complex divideBy(Complex other) {
        if (other.isZero()) {
            return new Complex(this.real * Double.POSITIVE_INFINITY,
                    this.getImaginary() * Double.POSITIVE_INFINITY);
        }
        Complex otherConjugated = other.conjugate();
        Complex dividend = this.multiply(otherConjugated);
        double divisor = other.multiplyByConjugated().getReal();
        return new Complex(dividend.getReal()/divisor, dividend.getImaginary()/divisor);
    }

    public Complex conjugate() {
        return new Complex(this.real, - this.imaginary);
    }

    public Complex multiplyByConjugated() {
        Complex conjugated = this.conjugate();
        return this.multiply(conjugated);
    }

    public double modulus() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public boolean isZero() {
        return this.real == 0 && this.getImaginary() == 0;
    }

    public Complex power(int exponent) {
        if (exponent == 0) {
            return new Complex(1, 0);
        }
        if (exponent == 1) {
            return this;
        }
        return this.multiply(power(exponent - 1));
    }
}
