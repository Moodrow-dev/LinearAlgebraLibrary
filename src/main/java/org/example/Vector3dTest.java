package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;

import static org.junit.Assert.assertEquals;

public class Vector3dTest {

    @Test
    public void testVector3dVectorProduct() {
        Vector3d v1 = new Vector3d(1, 0, 0);
        Vector3d v2 = new Vector3d(0, 1, 0);
        Vector3d result = v1.vectorProduct(v2);
        assertEquals(0.0, result.getCoordinates()[0], 1e-10F);
        assertEquals(0.0, result.getCoordinates()[1], 1e-10F);
        assertEquals(1.0, result.getCoordinates()[2], 1e-10F);
    }

    @Test
    public void testVector3dOrthogonality() {
        Vector3d v1 = new Vector3d(2, 3, 4);
        Vector3d v2 = new Vector3d(5, 6, 7);
        Vector3d cross = v1.vectorProduct(v2);

        // Векторное произведение должно быть ортогонально исходным векторам
        assertEquals(0.0, v1.scalarProduct(cross), 1e-10F);
        assertEquals(0.0, v2.scalarProduct(cross), 1e-10F);
    }

    @Test
    public void testVector3dLength() {
        Vector3d v = new Vector3d(1, 2, 2);
        assertEquals(3.0, v.length(), 1e-10F);
    }

    @Test
    public void testVector3dMultipleAddition() {
        Vector3d v1 = new Vector3d(1, 1, 1);
        Vector3d v2 = new Vector3d(2, 2, 2);
        Vector3d v3 = new Vector3d(3, 3, 3);
        Vector3d result = v1.add(v2, v3);
        assertEquals(6.0, result.getCoordinates()[0], 1e-10F);
        assertEquals(6.0, result.getCoordinates()[1], 1e-10F);
        assertEquals(6.0, result.getCoordinates()[2], 1e-10F);
    }

    @Test
    public void testVector3dAnticommutativity() {
        Vector3d v1 = new Vector3d(1, 2, 3);
        Vector3d v2 = new Vector3d(4, 5, 6);
        Vector3d cross1 = v1.vectorProduct(v2);
        Vector3d cross2 = v2.vectorProduct(v1);

        // a × b = - (b × a)
        assertEquals(-cross1.getCoordinates()[0], cross2.getCoordinates()[0], 1e-10F);
        assertEquals(-cross1.getCoordinates()[1], cross2.getCoordinates()[1], 1e-10F);
        assertEquals(-cross1.getCoordinates()[2], cross2.getCoordinates()[2], 1e-10F);
    }
}