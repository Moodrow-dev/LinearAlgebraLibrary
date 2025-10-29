package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.*;
public class Matrix2x2 extends AbstractMatrix<Matrix2x2> {

    public Matrix2x2(float[][] data) {
        super(data, 2, 2);
    }

    public static Matrix2x2 zero() {
        return new Matrix2x2(new float[][]{{0, 0}, {0, 0}});
    }

    public static Matrix2x2 identity() {
        return new Matrix2x2(new float[][]{{1, 0}, {0, 1}});
    }

    @Override
    public Matrix2x2 add(Matrix2x2 other) {
        return new Matrix2x2(addMatrices(other.data));
    }

    @Override
    public Matrix2x2 subtract(Matrix2x2 other) {
        return new Matrix2x2(subtractMatrices(other.data));
    }

    @Override
    public Matrix2x2 multiply(Matrix2x2 other) {
        return new Matrix2x2(multiplyMatrices(other.data, 2));
    }

    @Override
    public Matrix2x2 transpose() {
        return new Matrix2x2(transposeMatrix());
    }

    @Override
    public Vector2d multiply(Vector vector) {
        if (!(vector instanceof Vector2d)) {
            throw new IllegalArgumentException("Matrix2x2 can only multiply Vector2d");
        }
        Vector2d v = (Vector2d) vector;
        float[] result = new float[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i] += data[i][j] * v.getCoordinates()[j];
            }
        }
        return new Vector2d(result);
    }

    public float determinant() {
        return data[0][0] * data[1][1] - data[0][1] * data[1][0];
    }

}