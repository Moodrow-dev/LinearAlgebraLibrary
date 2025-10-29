package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix3x3;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;

public class Matrix3x3Test {

    public void testMatrix3x3Operations() {
        System.out.println("=== Matrix3x3 Basic Operations ===");

        Matrix3x3 m1 = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3x3 m2 = new Matrix3x3(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        System.out.println("Matrix m1:");
        printMatrix3x3(m1);
        System.out.println("Matrix m2:");
        printMatrix3x3(m2);

        // Сложение
        Matrix3x3 addResult = m1.add(m2);
        System.out.println("Matrix addition (m1 + m2):");
        printMatrix3x3(addResult);

        // Вычитание
        Matrix3x3 subResult = m1.subtract(m2);
        System.out.println("Matrix subtraction (m1 - m2):");
        printMatrix3x3(subResult);

        System.out.println();
    }
    public void testMatrix3x3SpecialMatrices() {
        System.out.println("=== Matrix3x3 Special Matrices ===");

        Matrix3x3 zero = Matrix3x3.zero();
        Matrix3x3 identity = Matrix3x3.identity();

        System.out.println("Zero matrix:");
        printMatrix3x3(zero);

        System.out.println("Identity matrix:");
        printMatrix3x3(identity);

        // Проверка свойств единичной матрицы
        Matrix3x3 testMatrix = new Matrix3x3(new float[][]{
                {2, 3, 1},
                {4, 5, 6},
                {7, 8, 9}
        });

        System.out.println("Test matrix:");
        printMatrix3x3(testMatrix);

        Matrix3x3 multWithIdentity = testMatrix.multiply(identity);
        System.out.println("Test matrix * Identity:");
        printMatrix3x3(multWithIdentity);
        System.out.println("Matrices equal: " + matricesEqual(testMatrix, multWithIdentity));

        Matrix3x3 addWithZero = testMatrix.add(zero);
        System.out.println("Test matrix + Zero:");
        printMatrix3x3(addWithZero);
        System.out.println("Matrices equal: " + matricesEqual(testMatrix, addWithZero));

        System.out.println();
    }

    private boolean matricesEqual(Matrix3x3 m1, Matrix3x3 m2) {
        float[][] d1 = m1.getData();
        float[][] d2 = m2.getData();
        for (int i = 0; i < d1.length; i++) {
            for (int j = 0; j < d1[i].length; j++) {
                if (Math.abs(d1[i][j] - d2[i][j]) > 1e-10) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printMatrix3x3(Matrix3x3 matrix) {
        float[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%6.1f ", data[i][j]);
            }
            System.out.println("]");
        }
    }

}
