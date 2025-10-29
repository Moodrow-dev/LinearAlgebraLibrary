package ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Matrix;

import ru.vsu.cs.kg25.g4.makarov_a_v.LinearAlgebraLibrary.Vector.Vector;

public interface Matrix<T extends Matrix<T>> {
    // Базовые операции
    T add(T other);

    T subtract(T other);

    T multiply(T other);

    T transpose();

    Vector multiply(Vector vector);

    // Информационные методы
    float[][] getData();

    int getRows();

    int getCols();

    // Утилитарные методы
    boolean equals(Object obj);

    String toString();
}