package com.geekbrains.Lesson_4;

public class hw_4 {
    public static double calcTriangArea (double sideA, double sideB, double sideC) throws Exception {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) throw new Exception();
        double halfPerimetr = (sideA+sideB+sideC)/2;
        double triangleSquare = (halfPerimetr*(halfPerimetr-sideA)*(halfPerimetr-sideB)*(halfPerimetr-sideC));
        return Math.sqrt(triangleSquare);

    }
}
