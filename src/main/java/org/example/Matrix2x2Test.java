package org.example;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix2x2;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector2d;

public class Matrix2x2Test {

    public void testMatrix2x2Operations() {
        System.out.println("=== Matrix2x2 Tests ===");

        Matrix2x2 m1 = new Matrix2x2(new float[][]{{1, 2}, {3, 4}});
        Matrix2x2 m2 = new Matrix2x2(new float[][]{{5, 6}, {7, 8}});

        System.out.println("Matrix m1:");
        printMatrix(m1);
        System.out.println("Matrix m2:");
        printMatrix(m2);

        // Сложение
        Matrix2x2 addResult = m1.add(m2);
        System.out.println("Matrix addition result:");
        printMatrix(addResult);

        // Умножение
        Matrix2x2 multResult = m1.multiply(m2);
        System.out.println("Matrix multiplication result:");
        printMatrix(multResult);
        System.out.println("Multiplication details:");
        System.out.println("Row1: " + m1.getData()[0][0] + "*" + m2.getData()[0][0] + " + " + m1.getData()[0][1] + "*" + m2.getData()[1][0] + " = " + multResult.getData()[0][0]);
        System.out.println("      " + m1.getData()[0][0] + "*" + m2.getData()[0][1] + " + " + m1.getData()[0][1] + "*" + m2.getData()[1][1] + " = " + multResult.getData()[0][1]);
        System.out.println("Row2: " + m1.getData()[1][0] + "*" + m2.getData()[0][0] + " + " + m1.getData()[1][1] + "*" + m2.getData()[1][0] + " = " + multResult.getData()[1][0]);
        System.out.println("      " + m1.getData()[1][0] + "*" + m2.getData()[0][1] + " + " + m1.getData()[1][1] + "*" + m2.getData()[1][1] + " = " + multResult.getData()[1][1]);

        // Определитель
        float det = m1.determinant();
        System.out.println("Determinant of m1: " + det);
        System.out.println("Calculation: " + m1.getData()[0][0] + "*" + m1.getData()[1][1] + " - " + m1.getData()[0][1] + "*" + m1.getData()[1][0] + " = " + det);

        // Транспонирование
        Matrix2x2 transpose = m1.transpose();
        System.out.println("Transpose of m1:");
        printMatrix(transpose);

        // Умножение на вектор
        Vector2d vector = new Vector2d(2, 3);
        Vector2d vectorResult = m1.multiply(vector);
        System.out.println("Matrix * Vector:");
        System.out.println("Matrix:");
        printMatrix(m1);
        System.out.println("Vector: (" + vector.getCoordinates()[0] + "," + vector.getCoordinates()[1] + ")");
        System.out.println("Result: (" + vectorResult.getCoordinates()[0] + "," + vectorResult.getCoordinates()[1] + ")");
        System.out.println("Calculation:");
        System.out.println("x: " + m1.getData()[0][0] + "*" + vector.getCoordinates()[0] + " + " + m1.getData()[0][1] + "*" + vector.getCoordinates()[1] + " = " + vectorResult.getCoordinates()[0]);
        System.out.println("y: " + m1.getData()[1][0] + "*" + vector.getCoordinates()[0] + " + " + m1.getData()[1][1] + "*" + vector.getCoordinates()[1] + " = " + vectorResult.getCoordinates()[1]);

        System.out.println();
    }

    public void testMatrix2x2SpecialMatrices() {
        System.out.println("=== Matrix2x2 Special Matrices ===");

        Matrix2x2 zero = Matrix2x2.zero();
        Matrix2x2 identity = Matrix2x2.identity();
        Matrix2x2 regular = new Matrix2x2(new float[][]{{2, 3}, {4, 5}});

        System.out.println("Zero matrix:");
        printMatrix(zero);

        System.out.println("Identity matrix:");
        printMatrix(identity);

        System.out.println("Regular matrix:");
        printMatrix(regular);

        // Проверка свойств
        Matrix2x2 multWithIdentity = regular.multiply(identity);
        System.out.println("Regular * Identity:");
        printMatrix(multWithIdentity);
        System.out.println("Matrices equal: " + matricesEqual(regular, multWithIdentity));

        Matrix2x2 addWithZero = regular.add(zero);
        System.out.println("Regular + Zero:");
        printMatrix(addWithZero);
        System.out.println("Matrices equal: " + matricesEqual(regular, addWithZero));

        System.out.println();
    }

    private void printMatrix(Matrix2x2 matrix) {
        float[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    private boolean matricesEqual(Matrix2x2 m1, Matrix2x2 m2) {
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