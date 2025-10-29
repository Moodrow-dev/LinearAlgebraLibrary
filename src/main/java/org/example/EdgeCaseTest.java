package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix2x2;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;

import static org.junit.Assert.assertEquals;

public class EdgeCaseTest {

    @Test
    public void testZeroVectorOperations() {
        Vector3d zero = new Vector3d(0, 0, 0);
        Vector3d v = new Vector3d(1, 2, 3);

        assertEquals(0.0, zero.length(), 1e-10);
        assertEquals(v.getCoordinates()[0], zero.add(v).getCoordinates()[0], 1e-10);
        assertEquals(0.0, zero.scalarProduct(v), 1e-10);
    }

    @Test
    public void testOrthogonalVectors() {
        Vector3d v1 = new Vector3d(1, 0, 0);
        Vector3d v2 = new Vector3d(0, 1, 0);
        assertEquals(0.0, v1.scalarProduct(v2), 1e-10F);
    }

    @Test
    public void testParallelVectors() {
        Vector3d v1 = new Vector3d(2, 4, 6);
        Vector3d v2 = new Vector3d(1, 2, 3);
        Vector3d cross = v1.vectorProduct(v2);
        assertEquals(0.0, cross.length(), 1e-10F); // Параллельные векторы имеют нулевое векторное произведение
    }

    @Test
    public void testMatrixSingularity() {
        Matrix2x2 singular = new Matrix2x2(new float[][]{{1, 2}, {2, 4}});
        assertEquals(0.0, singular.determinant(), 1e-10F); // 1*4 - 2*2 = 0
    }
}
