package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

import static org.junit.Assert.assertEquals;

public class Vector4dTest {

    @Test
    public void testVector4dLength() {
        Vector4d v = new Vector4d(1, 1, 1, 1);
        assertEquals(2.0, v.length(), 1e-10F); // sqrt(1+1+1+1) = 2
    }

    @Test
    public void testVector4dScalarProduct() {
        Vector4d v1 = new Vector4d(1, 2, 3, 4);
        Vector4d v2 = new Vector4d(5, 6, 7, 8);
        float result = v1.scalarProduct(v2);
        assertEquals(70.0, result, 1e-10F); // 1*5 + 2*6 + 3*7 + 4*8 = 70
    }

    @Test
    public void testVector4dMultipleVectors() {
        Vector4d v1 = new Vector4d(1, 0, 0, 0);
        Vector4d v2 = new Vector4d(0, 1, 0, 0);
        Vector4d v3 = new Vector4d(0, 0, 1, 0);
        Vector4d result = v1.add(v2, v3);
        assertEquals(1.0, result.getCoordinates()[0], 1e-10F);
        assertEquals(1.0, result.getCoordinates()[1], 1e-10F);
        assertEquals(1.0, result.getCoordinates()[2], 1e-10F);
        assertEquals(0.0, result.getCoordinates()[3], 1e-10F);
    }
}