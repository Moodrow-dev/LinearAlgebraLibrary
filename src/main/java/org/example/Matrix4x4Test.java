package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix4x4;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Matrix4x4Test {

    @Test
    public void testMatrix4x4Multiplication() {
        Matrix4x4 m1 = new Matrix4x4(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        Matrix4x4 m2 = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
        Matrix4x4 result = m1.multiply(m2);
        assertArrayEquals(m1.getData()[0], result.getData()[0], 1e-10F);
        assertArrayEquals(m1.getData()[1], result.getData()[1], 1e-10F);
        assertArrayEquals(m1.getData()[2], result.getData()[2], 1e-10F);
        assertArrayEquals(m1.getData()[3], result.getData()[3], 1e-10F);
    }

    @Test
    public void testMatrix4x4VectorMultiplication() {
        Matrix4x4 m = new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 3, 0},
                {0, 0, 0, 4}
        });
        Vector4d v = new Vector4d(2, 3, 4, 5);
        Vector4d result = m.multiply(v);
        assertEquals(2.0, result.getCoordinates()[0], 1e-10F);  // 1*2
        assertEquals(6.0, result.getCoordinates()[1], 1e-10F);  // 2*3
        assertEquals(12.0, result.getCoordinates()[2], 1e-10F); // 3*4
        assertEquals(20.0, result.getCoordinates()[3], 1e-10F); // 4*5
    }

    @Test
    public void testMatrix4x4Transpose() {
        Matrix4x4 m = new Matrix4x4(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        Matrix4x4 result = m.transpose();
        assertEquals(1.0, result.getData()[0][0], 1e-10F);
        assertEquals(5.0, result.getData()[0][1], 1e-10F);
        assertEquals(9.0, result.getData()[0][2], 1e-10F);
        assertEquals(13.0, result.getData()[0][3], 1e-10F);
    }
}