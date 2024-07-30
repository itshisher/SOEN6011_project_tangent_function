package com.soen6011.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TangentTest {

    @Test
    public void testCalculateTangent_Zero() {
        assertEquals(0, Tangent.calculateTangent(0), 0.001, "Tangent of 0 should be 0");
    }

    @Test
    public void testCalculateTangent_PiDiv2() {
        assertThrows(ArithmeticException.class, () -> {
            Tangent.calculateTangent(Math.PI / 2);
        }, "Tangent of PI/2 should throw an ArithmeticException");
    }

    @Test
    public void testCalculateTangent_Pi() {
        assertEquals(0, Tangent.calculateTangent(Math.PI), 0.001, "Tangent of PI should be 0");
    }

    @Test
    public void testCalculateTangent_NegativePiDiv2() {
        assertThrows(ArithmeticException.class, () -> {
            Tangent.calculateTangent(-Math.PI / 2);
        }, "Tangent of -PI/2 should throw an ArithmeticException");
    }

    @Test
    public void testCalculateTangent_ThreePiDiv2() {
        assertThrows(ArithmeticException.class, () -> {
            Tangent.calculateTangent(3 * Math.PI / 2);
        }, "Tangent of 3*PI/2 should throw an ArithmeticException");
    }
}
