package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix.Matrix2x2;

public class Vector3d extends AbstractVector<Vector3d> {
    public Vector3d(float x, float y, float z) {
        super(new float[]{x, y, z});
    }

    public Vector3d(float[] coordinates) {
        super(validateCoordinates(coordinates));
    }

    private static float[] validateCoordinates(float[] coordinates) {
        if (coordinates.length != 3) {
            throw new IllegalArgumentException("Vector3d requires exactly 3 coordinates");
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

    @Override
    public Vector3d add(Vector3d... vectors) {
        float newX = coordinates[0];
        float newY = coordinates[1];
        float newZ = coordinates[2];
        for (Vector3d v : vectors) {
            newX += v.getX();
            newY += v.getY();
            newZ += v.getZ();
        }
        return new Vector3d(newX, newY, newZ);
    }

    @Override
    public Vector3d subtract(Vector3d... vectors) {
        float newX = coordinates[0];
        float newY = coordinates[1];
        float newZ = coordinates[2];
        for (Vector3d v : vectors) {
            newX -= v.getX();
            newY -= v.getY();
            newZ -= v.getZ();
        }
        return new Vector3d(newX, newY, newZ);
    }

    @Override
    public Vector3d multiply(float scalar) {
        return new Vector3d(coordinates[0] * scalar, coordinates[1] * scalar, coordinates[2] * scalar);
    }

    @Override
    public Vector3d divide(float scalar) {
        if (scalar == 0) throw new IllegalArgumentException("Division by zero");
        return new Vector3d(coordinates[0] / scalar, coordinates[1] / scalar,coordinates[2] / scalar);
    }

    @Override
    public float scalarProduct(Vector3d... vectors) {
        float sum = 0;
        for (Vector3d v : vectors) {
            sum += coordinates[0] * v.getX() + coordinates[1] * v.getY() + coordinates[2]*v.getZ();
        }
        return sum;
    }

    public Vector3d vectorProduct(Vector3d vector) {
        float i = coordinates[1]*vector.getZ()-coordinates[2]*vector.getY();
        float j = coordinates[2]*vector.getX()-coordinates[0]*vector.getZ();
        float k = coordinates[0]*vector.getY()-coordinates[1]*vector.getX();
        return new Vector3d(i,j,k);
    }

    @Override
    public Vector3d normalize() {
        float len = length();
        if (len == 0) return new Vector3d(0,0,0);
        return divide(len);
    }
}
