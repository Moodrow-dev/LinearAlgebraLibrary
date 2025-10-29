package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix4x4;

import static org.junit.Assert.assertTrue;

public class PerformanceTest {

    @Test
    public void testMatrixMultiplicationPerformance() {
        Matrix4x4 m = Matrix4x4.identity();
        long startTime = System.nanoTime();

        // 1000 умножений матриц
        for (int i = 0; i < 1000; i++) {
            m = m.multiply(m);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Проверяем что операция выполняется за разумное время
        assertTrue(duration < 1_000_000_000); // Меньше 1 секунды
    }
}
