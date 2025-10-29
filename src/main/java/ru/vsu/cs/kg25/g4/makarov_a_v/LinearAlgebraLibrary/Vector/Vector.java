package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector;

public interface Vector<T extends Vector<T>> {
    // Базовые операции
    T add(T... vectors);

    T subtract(T... vectors);

    T multiply(float scalar);

    T divide(float scalar);

    T normalize();

    // Математические операции
    float length();

    float scalarProduct(T... vectors);

    // Информационные методы
    float[] getCoordinates();

    int getDimension();

    // Утилитарные методы
    boolean equals(Object obj);

    String toString();
}