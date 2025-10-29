package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;

public class Vector3dTest {

    public void testVector3dOperations() {
        System.out.println("=== Vector3d Tests ===");

        Vector3d v1 = new Vector3d(1, 2, 3);
        Vector3d v2 = new Vector3d(4, 5, 6);

        // Векторное произведение
        Vector3d crossProduct = v1.vectorProduct(v2);
        System.out.println("Cross product: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + "," + v1.getCoordinates()[2] + ") × (" +
                v2.getCoordinates()[0] + "," + v2.getCoordinates()[1] + "," + v2.getCoordinates()[2] + ") = (" +
                crossProduct.getCoordinates()[0] + "," + crossProduct.getCoordinates()[1] + "," + crossProduct.getCoordinates()[2] + ")");

        // Проверка ортогональности
        float dot1 = v1.scalarProduct(crossProduct);
        float dot2 = v2.scalarProduct(crossProduct);
        System.out.println("Orthogonality check:");
        System.out.println("v1 · (v1×v2) = " + dot1);
        System.out.println("v2 · (v1×v2) = " + dot2);

        // Антикоммутативность
        Vector3d crossReverse = v2.vectorProduct(v1);
        System.out.println("Anticommutativity:");
        System.out.println("v1×v2 = (" + crossProduct.getCoordinates()[0] + "," + crossProduct.getCoordinates()[1] + "," + crossProduct.getCoordinates()[2] + ")");
        System.out.println("v2×v1 = (" + crossReverse.getCoordinates()[0] + "," + crossReverse.getCoordinates()[1] + "," + crossReverse.getCoordinates()[2] + ")");
        System.out.println("v1×v2 = -v2×v1: " +
                (-crossProduct.getCoordinates()[0] == crossReverse.getCoordinates()[0]) + ", " +
                (-crossProduct.getCoordinates()[1] == crossReverse.getCoordinates()[1]) + ", " +
                (-crossProduct.getCoordinates()[2] == crossReverse.getCoordinates()[2]));

        System.out.println();
    }

    public void testVector3dStandardCases() {
        System.out.println("=== Vector3d Standard Cases ===");

        // Базовые векторы
        Vector3d i = new Vector3d(1, 0, 0);
        Vector3d j = new Vector3d(0, 1, 0);
        Vector3d k = new Vector3d(0, 0, 1);

        Vector3d ixj = i.vectorProduct(j);
        System.out.println("i × j = (" + ixj.getCoordinates()[0] + "," + ixj.getCoordinates()[1] + "," + ixj.getCoordinates()[2] + ")");
        System.out.println("Expected: (0,0,1)");

        Vector3d jxk = j.vectorProduct(k);
        System.out.println("j × k = (" + jxk.getCoordinates()[0] + "," + jxk.getCoordinates()[1] + "," + jxk.getCoordinates()[2] + ")");
        System.out.println("Expected: (1,0,0)");

        Vector3d kxi = k.vectorProduct(i);
        System.out.println("k × i = (" + kxi.getCoordinates()[0] + "," + kxi.getCoordinates()[1] + "," + kxi.getCoordinates()[2] + ")");
        System.out.println("Expected: (0,1,0)");

        System.out.println();
    }
}