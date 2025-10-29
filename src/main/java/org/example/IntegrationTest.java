package org.example;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix2x2;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix3x3;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector2d;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    @Test
    public void testVectorMatrixChainOperations() {
        // Создаем вектор и матрицу
        Vector3d v = new Vector3d(1, 2, 3);
        Matrix3x3 rotation = new Matrix3x3(new float[][]{
                {0, -1, 0},
                {1, 0, 0},
                {0, 0, 1}
        });

        // Поворачиваем вектор на 90 градусов вокруг Z
        Vector3d rotated = rotation.multiply(v);
        assertEquals(-2.0, rotated.getCoordinates()[0], 1e-10F); // x' = -y
        assertEquals(1.0, rotated.getCoordinates()[1], 1e-10F);  // y' = x
        assertEquals(3.0, rotated.getCoordinates()[2], 1e-10F);  // z' = z
    }

    @Test
    public void testMultipleTransformations() {
        Vector2d v = new Vector2d(2, 3);
        Matrix2x2 scale = new Matrix2x2(new float[][]{{2, 0}, {0, 2}});
        Matrix2x2 translate = new Matrix2x2(new float[][]{{1, 1}, {0, 1}});

        // Масштабирование и затем сдвиг
        Vector2d scaled = scale.multiply(v);
        Vector2d finalVector = translate.multiply(scaled);

        assertEquals(7.0, finalVector.getCoordinates()[0], 1e-10F); // (2*2) + (3*1)
        assertEquals(6.0, finalVector.getCoordinates()[1], 1e-10F); // (2*3)
    }
}