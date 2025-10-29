package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector2d;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class Vector2dTest {

    @Test
    public void testVector2dAddition() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d result = v1.add(v2);
        assertEquals(4.0, result.getCoordinates()[0], 1e-10F);
        assertEquals(6.0, result.getCoordinates()[1], 1e-10F);
    }

    @Test
    public void testVector2dSubtraction() {
        Vector2d v1 = new Vector2d(5, 7);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d result = v1.subtract(v2);
        assertEquals(3.0, result.getCoordinates()[0], 1e-10F);
        assertEquals(4.0, result.getCoordinates()[1], 1e-10F);
    }

    @Test
    public void testVector2dLength() {
        Vector2d v = new Vector2d(3, 4);
        assertEquals(5.0, v.length(), 1e-10F);
    }

    @Test
    public void testVector2dNormalization() {
        Vector2d v = new Vector2d(3, 4);
        Vector2d normalized = v.normalize();
        assertEquals(1.0, normalized.length(), 1e-10F);
        assertEquals(0.6, normalized.getCoordinates()[0], 1e-10F);
        assertEquals(0.8, normalized.getCoordinates()[1], 1e-10F);
    }

    @Test
    public void testVector2dScalarProduct() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);
        float result = v1.scalarProduct(v2);
        assertEquals(23.0, result, 1e-10F);
    }

    @Test
    public void testVector2dZeroLength() {
        Vector2d v = new Vector2d(0, 0);
        assertEquals(0.0, v.length(), 1e-10F);
    }

    @Test
    public void testVector2dConstructorValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vector2d(new float[]{1}); // Недостаточно координат
        });
    }
}