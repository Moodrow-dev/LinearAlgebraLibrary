package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector;

import java.util.Arrays;

public abstract class AbstractVector<T extends AbstractVector<T>> implements Vector<T> {
    protected final float[] coordinates;

    protected AbstractVector(float[] coordinates) {
        this.coordinates = coordinates.clone();
    }

    @Override
    public float[] getCoordinates() {
        return coordinates.clone();
    }

    @Override
    public int getDimension() {
        return coordinates.length;
    }

    @Override
    public float length() {
        float sum = 0;
        for (float coord : coordinates) {
            sum += coord * coord;
        }
        return (float) Math.sqrt(sum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractVector<?> that = (AbstractVector<?>) obj;
        return Arrays.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }
}