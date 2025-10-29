package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

public class Matrix4x4 extends AbstractMatrix<Matrix4x4> {

    public Matrix4x4(float[][] data) {
        super(data, 4, 4);
    }

    public static Matrix4x4 zero() {
        return new Matrix4x4(new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
    }

    public static Matrix4x4 identity() {
        return new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    @Override
    public Matrix4x4 add(Matrix4x4 other) {
        return new Matrix4x4(addMatrices(other.data));
    }

    @Override
    public Matrix4x4 subtract(Matrix4x4 other) {
        return new Matrix4x4(subtractMatrices(other.data));
    }

    @Override
    public Matrix4x4 multiply(Matrix4x4 other) {
        return new Matrix4x4(multiplyMatrices(other.data, 4));
    }

    @Override
    public Matrix4x4 transpose() {
        return new Matrix4x4(transposeMatrix());
    }

    @Override
    public Vector4d multiply(Vector vector) {
        if (!(vector instanceof Vector4d)) {
            throw new IllegalArgumentException("Matrix4x4 can only multiply Vector4d");
        }
        Vector4d v = (Vector4d) vector;
        float[] result = new float[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i] += data[i][j] * v.getCoordinates()[j];
            }
        }
        return new Vector4d(result);
    }

}