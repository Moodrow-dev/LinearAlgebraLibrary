package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix;


import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector3d;
import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector4d;

public class Matrix3x3 extends AbstractMatrix<Matrix3x3> {

    public Matrix3x3(float[][] data) {
        super(data,3,3);
    }

    public static Matrix3x3 zero() {
        return new Matrix3x3(new float[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
    }

    public static Matrix3x3 identity() {
        return new Matrix3x3(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        });
    }

    @Override
    public Matrix3x3 add(Matrix3x3 other) {
        return new Matrix3x3(addMatrices(other.data));
    }

    @Override
    public Matrix3x3 subtract(Matrix3x3 other) {
        return new Matrix3x3(subtractMatrices(other.data));
    }

    @Override
    public Matrix3x3 multiply(Matrix3x3 other) {
        return new Matrix3x3(multiplyMatrices(other.data, 3));
    }

    @Override
    public Vector3d multiply(Vector vector) {
        if (!(vector instanceof Vector3d)) {
            throw new IllegalArgumentException("Matrix3x3 can only multiply Vector3d");
        }
        Vector3d v = (Vector3d) vector;
        float[] result = new float[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i] += data[i][j] * v.getCoordinates()[j];
            }
        }
        return new Vector3d(result);
    }

    @Override
    public Matrix3x3 transpose() {
        return new Matrix3x3(transposeMatrix());
    }

    public float determinant() {
        float value = 0;
        for (int i = 0; i < 3; i++) {
            float temp = 1;
            for (int j = 0; j < 3; j++) {
                temp*=data[j][(j+i)%3];
            }
            value += temp;
        }

        for (int i = 0; i < 3; i++) {
            float temp = 1;
            for (int j = 0; j < 3; j++) {
                temp*=data[j][3-1-(j+i)%3];
            }
            value -= temp;
        }
        return value;
    }
}
