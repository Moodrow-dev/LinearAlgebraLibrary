package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector;

public class Vector2d extends AbstractVector<Vector2d> {
    public Vector2d(float x, float y) {
        super(new float[]{x, y});
    }

    public Vector2d(float[] coordinates) {
        super(validateCoordinates(coordinates));
    }

    private static float[] validateCoordinates(float[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Vector2d requires exactly 2 coordinates");
        }
        return coordinates;
    }

    public float getX() {
        return coordinates[0];
    }

    public float getY() {
        return coordinates[1];
    }

    @Override
    public Vector2d add(Vector2d... vectors) {
        float newX = coordinates[0];
        float newY = coordinates[1];
        for (Vector2d v : vectors) {
            newX += v.getX();
            newY += v.getY();
        }
        return new Vector2d(newX, newY);
    }

    @Override
    public Vector2d subtract(Vector2d... vectors) {
        float newX = coordinates[0];
        float newY = coordinates[1];
        for (Vector2d v : vectors) {
            newX -= v.getX();
            newY -= v.getY();
        }
        return new Vector2d(newX, newY);
    }

    @Override
    public Vector2d multiply(float scalar) {
        return new Vector2d(coordinates[0] * scalar, coordinates[1] * scalar);
    }

    @Override
    public Vector2d divide(float scalar) {
        if (scalar == 0) throw new IllegalArgumentException("Division by zero");
        return new Vector2d(coordinates[0] / scalar, coordinates[1] / scalar);
    }

    @Override
    public Vector2d normalize() {
        float len = length();
        if (len == 0) return new Vector2d(0, 0);
        return divide(len);
    }

    @Override
    public float scalarProduct(Vector2d... vectors) {
        float sum = 0;
        for (Vector2d v : vectors) {
            sum += coordinates[0] * v.getX() + coordinates[1] * v.getY();
        }
        return sum;
    }
}
