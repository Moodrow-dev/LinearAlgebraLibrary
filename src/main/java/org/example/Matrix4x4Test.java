package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix4x4;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

public class Matrix4x4Test {

    public void testMatrix4x4Operations() {
        System.out.println("=== Matrix4x4 Tests ===");

        Matrix4x4 m1 = new Matrix4x4(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4x4 identity = Matrix4x4.identity();

        System.out.println("Matrix m1:");
        printMatrix4x4(m1);
        System.out.println("Identity matrix:");
        printMatrix4x4(identity);

        // Умножение на единичную матрицу
        Matrix4x4 multWithIdentity = m1.multiply(identity);
        System.out.println("m1 * Identity:");
        printMatrix4x4(multWithIdentity);
        System.out.println("Matrices equal: " + matricesEqual(m1, multWithIdentity));

        // Транспонирование
        Matrix4x4 transpose = m1.transpose();
        System.out.println("Transpose of m1:");
        printMatrix4x4(transpose);
        System.out.println("Transpose check - m1[0][1] = " + m1.getData()[0][1] + ", transpose[1][0] = " + transpose.getData()[1][0]);

        // Умножение на вектор
        Vector4d vector = new Vector4d(1, 2, 3, 4);
        Vector4d vectorResult = m1.multiply(vector);
        System.out.println("Matrix * Vector:");
        System.out.println("Vector: (" + vector.getCoordinates()[0] + "," + vector.getCoordinates()[1] + "," +
                vector.getCoordinates()[2] + "," + vector.getCoordinates()[3] + ")");
        System.out.println("Result: (" + vectorResult.getCoordinates()[0] + "," + vectorResult.getCoordinates()[1] + "," +
                vectorResult.getCoordinates()[2] + "," + vectorResult.getCoordinates()[3] + ")");

        System.out.println();
    }

    public void testMatrix4x4ComplexMultiplication() {
        System.out.println("=== Matrix4x4 Complex Multiplication ===");

        Matrix4x4 A = new Matrix4x4(new float[][]{
                {2, 0, 0, 0},
                {0, 3, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 4}
        });

        Matrix4x4 B = new Matrix4x4(new float[][]{
                {1, 2, 0, 1},
                {0, 1, 1, 0},
                {2, 0, 1, 1},
                {0, 1, 0, 1}
        });

        System.out.println("Matrix A (diagonal):");
        printMatrix4x4(A);
        System.out.println("Matrix B:");
        printMatrix4x4(B);

        Matrix4x4 result = A.multiply(B);
        System.out.println("A * B:");
        printMatrix4x4(result);

        // Покажем вычисление одного элемента
        System.out.println("Sample calculation - element [0][1]:");
        System.out.println("A[0][0]*B[0][1] + A[0][1]*B[1][1] + A[0][2]*B[2][1] + A[0][3]*B[3][1]");
        System.out.println(A.getData()[0][0] + "*" + B.getData()[0][1] + " + " +
                A.getData()[0][1] + "*" + B.getData()[1][1] + " + " +
                A.getData()[0][2] + "*" + B.getData()[2][1] + " + " +
                A.getData()[0][3] + "*" + B.getData()[3][1] + " = " + result.getData()[0][1]);

        System.out.println();
    }

    private void printMatrix4x4(Matrix4x4 matrix) {
        float[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%6.1f ", data[i][j]);
            }
            System.out.println("]");
        }
    }

    private boolean matricesEqual(Matrix4x4 m1, Matrix4x4 m2) {
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
}