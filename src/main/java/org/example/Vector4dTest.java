package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

public class Vector4dTest {

    public void testVector4dOperations() {
        System.out.println("=== Vector4d Tests ===");

        Vector4d v1 = new Vector4d(1, 2, 3, 4);
        Vector4d v2 = new Vector4d(5, 6, 7, 8);

        System.out.println("Vector v1: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + "," +
                v1.getCoordinates()[2] + "," + v1.getCoordinates()[3] + ")");
        System.out.println("Vector v2: (" + v2.getCoordinates()[0] + "," + v2.getCoordinates()[1] + "," +
                v2.getCoordinates()[2] + "," + v2.getCoordinates()[3] + ")");

        // Сложение
        Vector4d addResult = v1.add(v2);
        System.out.println("Addition result: (" + addResult.getCoordinates()[0] + "," + addResult.getCoordinates()[1] + "," +
                addResult.getCoordinates()[2] + "," + addResult.getCoordinates()[3] + ")");

        // Скалярное произведение
        float dotProduct = v1.scalarProduct(v2);
        System.out.println("Dot product: " + dotProduct);
        System.out.println("Calculation: " + v1.getCoordinates()[0] + "*" + v2.getCoordinates()[0] + " + " +
                v1.getCoordinates()[1] + "*" + v2.getCoordinates()[1] + " + " +
                v1.getCoordinates()[2] + "*" + v2.getCoordinates()[2] + " + " +
                v1.getCoordinates()[3] + "*" + v2.getCoordinates()[3] + " = " + dotProduct);

        // Длина
        System.out.println("Length of v1: " + v1.length());
        System.out.println("Length calculation: sqrt(" + v1.getCoordinates()[0] + "² + " + v1.getCoordinates()[1] + "² + " +
                v1.getCoordinates()[2] + "² + " + v1.getCoordinates()[3] + "²) = " + v1.length());

        System.out.println();
    }
}