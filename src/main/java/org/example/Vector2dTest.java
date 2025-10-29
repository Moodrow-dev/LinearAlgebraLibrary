package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector2d;

public class Vector2dTest {
    
    public void testVector2dOperations() {
        System.out.println("=== Vector2d Tests ===");
        
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        
        // Сложение
        Vector2d addResult = v1.add(v2);
        System.out.println("Addition: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + ") + (" + 
                          v2.getCoordinates()[0] + "," + v2.getCoordinates()[1] + ") = (" + 
                          addResult.getCoordinates()[0] + "," + addResult.getCoordinates()[1] + ")");
        
        // Вычитание
        Vector2d subResult = v1.subtract(v2);
        System.out.println("Subtraction: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + ") - (" + 
                          v2.getCoordinates()[0] + "," + v2.getCoordinates()[1] + ") = (" + 
                          subResult.getCoordinates()[0] + "," + subResult.getCoordinates()[1] + ")");
        
        // Длина
        float length = v1.length();
        System.out.println("Length of (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + ") = " + length);
        
        // Нормализация
        Vector2d normalized = v1.normalize();
        System.out.println("Normalized: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + ") -> (" + 
                          normalized.getCoordinates()[0] + "," + normalized.getCoordinates()[1] + ")");
        System.out.println("Normalized length: " + normalized.length());
        
        // Скалярное произведение
        float dotProduct = v1.scalarProduct(v2);
        System.out.println("Dot product: (" + v1.getCoordinates()[0] + "," + v1.getCoordinates()[1] + ") · (" + 
                          v2.getCoordinates()[0] + "," + v2.getCoordinates()[1] + ") = " + dotProduct);
        
        System.out.println();
    }
}