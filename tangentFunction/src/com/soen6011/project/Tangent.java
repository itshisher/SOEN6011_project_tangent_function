package com.soen6011.project;

/**
 * Class to calculate the tangent of an angle using the Taylor series.
 */
public class Tangent {
    private static final double PI = 3.14159265358979;
    private static final double MinimumCheck = 1E-10;

    // Private constructor to prevent instantiation
    private Tangent() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Calculates the tangent of a given angle x.
     *
     * @param x Angle in radians
     * @return Tangent of the angle
     * @throws ArithmeticException if tangent is undefined for the given angle
     */
    public static double calculateTangent(double x) {
        x = x % PI; // Reduce x to within -PI to PI

        // Check if x is close to PI/2 or -PI/2 where tangent is undefined
        if (Math.abs(x - PI / 2) < MinimumCheck || Math.abs(x + PI / 2) < MinimumCheck) {
            throw new ArithmeticException("Tangent is undefined for this value.");
        }

        double sinValue = sin(x);
        double cosValue = cos(x);

        if (Math.abs(cosValue) < MinimumCheck) {
            throw new ArithmeticException("Tangent is undefined because cosine is zero.");
        }

        return sinValue / cosValue;
    }

    /**
     * Calculates the sine of an angle using its Taylor series expansion.
     *
     * @param x Angle in radians
     * @return Sine of the angle
     */
    private static double sin(double x) {
        double term = x;
        double sum = x;
        int n = 1;
        while (Math.abs(term) > MinimumCheck) {
            term *= -x * x / (2 * n * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    /**
     * Calculates the cosine of an angle using its Taylor series expansion.
     *
     * @param x Angle in radians
     * @return Cosine of the angle
     */
    private static double cos(double x) {
        double term = 1;
        double sum = 1;
        int n = 1;
        while (Math.abs(term) > MinimumCheck) {
            term *= -x * x / (2 * n - 1) / (2 * n);
            sum += term;
            n++;
        }
        return sum;
    }
}
