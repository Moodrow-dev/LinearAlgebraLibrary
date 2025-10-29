package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix2x2;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector2d;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Matrix2x2Test {

    @Test
    public void testMatrix2x2Addition() {
        Matrix2x2 m1 = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Matrix2x2 m2 = new Matrix2x2(new float[][]{{5, 6}, {7, 8}});
        Matrix2x2 result = m1.add(m2);
        assertArrayEquals(new float[]{6, 8}, result.getData()[0], 1e-10F);
        assertArrayEquals(new float[]{10, 12}, result.getData()[1], 1e-10F);
    }

    @Test
    public void testMatrix2x2Multiplication() {
        Matrix2x2 m1 = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Matrix2x2 m2 = new Matrix2x2(new float[][]{{2, 0}, {1, 2}});
        Matrix2x2 result = m1.multiply(m2);
        assertArrayEquals(new float[]{4, 4}, result.getData()[0], 1e-10F); // 1*2+2*1, 1*0+2*2
        assertArrayEquals(new float[]{10, 8}, result.getData()[1], 1e-10F); // 3*2+4*1, 3*0+4*2
    }

    @Test
    public void testMatrix2x2Determinant() {
        Matrix2x2 m = new Matrix2x2(new float[][]{{4, 3}, {6, 3}});
        assertEquals(-6.0, m.determinant(), 1e-10F); // 4*3 - 3*6 = -6
    }

    @Test
    public void testMatrix2x2VectorMultiplication() {
        Matrix2x2 m = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Vector2d v = new Vector2d(2, 3);
        Vector2d result = m.multiply(v);
        assertEquals(8.0, result.getCoordinates()[0], 1e-10F); // 1*2 + 2*3
        assertEquals(18.0, result.getCoordinates()[1], 1e-10F); // 3*2 + 4*3
    }

    @Test
    public void testMatrix2x2Transpose() {
        Matrix2x2 m = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Matrix2x2 result = m.transpose();
        assertArrayEquals(new float[]{1, 3}, result.getData()[0], 1e-10F);
        assertArrayEquals(new float[]{2, 4}, result.getData()[1], 1e-10F);
    }

    @Test
    public void testMatrix2x2Identity() {
        Matrix2x2 identity = Matrix2x2.identity();
        Matrix2x2 m = new Matrix2x2(new float[][]{{5, 6}, {7, 8}});
        Matrix2x2 result = m.multiply(identity);
        assertArrayEquals(m.getData()[0], result.getData()[0], 1e-10F);
        assertArrayEquals(m.getData()[1], result.getData()[1], 1e-10F);
    }

    @Test
    public void testMatrix2x2Zero() {
        Matrix2x2 zero = Matrix2x2.zero();
        Matrix2x2 m = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Matrix2x2 result = m.add(zero);
        assertArrayEquals(m.getData()[0], result.getData()[0], 1e-10F);
        assertArrayEquals(m.getData()[1], result.getData()[1], 1e-10F);
    }
}