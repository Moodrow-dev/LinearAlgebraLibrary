package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix;

import java.util.Arrays;

public abstract class AbstractMatrix<T extends AbstractMatrix<T>> implements Matrix<T> {
    protected final float[][] data;
    protected final int rows;
    protected final int cols;

    protected AbstractMatrix(float[][] data, int expectedRows, int expectedCols) {
        validateDimensions(data, expectedRows, expectedCols);
        this.data = deepCopy(data);
        this.rows = expectedRows;
        this.cols = expectedCols;
    }

    private void validateDimensions(float[][] data, int expectedRows, int expectedCols) {
        if (data.length != expectedRows) {
            throw new IllegalArgumentException(
                    String.format("Expected %d rows, got %d", expectedRows, data.length)
            );
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != expectedCols) {
                throw new IllegalArgumentException(
                        String.format("Row %d: expected %d columns, got %d", i, expectedCols, data[i].length)
                );
            }
        }
    }

    private float[][] deepCopy(float[][] original) {
        float[][] copy = new float[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    @Override
    public float[][] getData() {
        return deepCopy(data);
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    // Общие реализации методов
    protected float[][] addMatrices(float[][] otherData){
        validateDimensions(otherData, rows, cols);
        float[][] result = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] + otherData[i][j];
            }
        }
        return result;
    }

    protected float[][] subtractMatrices(float[][] otherData) {
        validateDimensions(otherData, rows, cols);
        float[][] result = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] - otherData[i][j];
            }
        }
        return result;
    }

    protected float[][] multiplyMatrices(float[][] otherData, int resultCols) {
        validateDimensions(otherData, rows, resultCols);
        float[][] result = new float[rows][resultCols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < resultCols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    result[i][j] += data[i][k] * otherData[k][j];
                }
            }
        }
        return result;
    }

    protected float[][] transposeMatrix() {
        float[][] result = new float[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = data[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractMatrix<?> that = (AbstractMatrix<?>) obj;
        if (rows != that.rows || cols != that.cols) return false;

        for (int i = 0; i < rows; i++) {
            if (!Arrays.equals(data[i], that.data[i])) {
                return false;
            }
        }
        return true;
    }
}
