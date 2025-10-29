package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector;

public class Vector4d extends AbstractVector<Vector4d> {
    public Vector4d(float x, float y, float z, float k) {
        super(new float[]{x, y, z, k});
    }

    public Vector4d(float[] coordinates) {
        super(validateCoordinates(coordinates));
    }

    private static float[] validateCoordinates(float[] coordinates) {
        if (coordinates.length != 4) {
            throw new IllegalArgumentException("Vector4d requires exactly 4 coordinates");
        }
        return coordinates;
    }

    public float getX() {
        return coordinates[0];
    }

    public float getY() {
        return coordinates[1];
    }

    public float getZ() {
        return coordinates[2];
    }

    public float getK() {
        return coordinates[3];
    }

    @Override
    public Vector4d add(Vector4d... vectors) {
        float newX = coordinates[0];
        float newY = coordinates[1];
        float newZ = coordinates[2];
        float newK = coordinates[3];
        for (Vector4d v : vectors) {
            newX += v.getX();
            newY += v.getY();
            newZ += v.getZ();
            newK += v.getK();
        }
        return new Vector4d(newX, newY, newZ, newK);
    }

    @Override
    public Vector4d subtract(Vector4d... vectors) throws IllegalArgumentException {
        float newX = coordinates[0];
        float newY = coordinates[1];
        float newZ = coordinates[2];
        float newK = coordinates[3];
        for (Vector4d v : vectors) {
            newX -= v.getX();
            newY -= v.getY();
            newZ -= v.getZ();
            newK -= v.getK();
        }
        return new Vector4d(newX, newY, newZ, newK);
    }

    @Override
    public Vector4d multiply(float scalar) {
        return new Vector4d(coordinates[0] * scalar, coordinates[1] * scalar, coordinates[2] * scalar,coordinates[3] * scalar);
    }

    @Override
    public Vector4d divide(float scalar) {
        if (scalar == 0) throw new IllegalArgumentException("Division by zero");
        return new Vector4d(coordinates[0] / scalar, coordinates[1] / scalar,coordinates[2] / scalar,coordinates[3] / scalar);
    }

    @Override
    public float scalarProduct(Vector4d... vectors) {
        float sum = 0;
        for (Vector4d v : vectors) {
            sum += coordinates[0] * v.getX() + coordinates[1] * v.getY() + coordinates[2]*v.getZ() + coordinates[3]*v.getK();
        }
        return sum;
    }

    @Override
    public Vector4d normalize() {
        float len = length();
        if (len == 0) return new Vector4d(0,0,0,0);
        return divide(len);
    }

}
