package ru.unn.agile.vectors.model;

public class Vector {
    private double x;
    private double y;
    private double z;
    public Vector(final double x0, final double y0, final double z0) {
        this.x = x0;
        this.y = y0;
        this.z = z0;
    }

    public static boolean isEqual(final Vector v1, final Vector v2) {
        return v1.x == v2.x && v1.y == v2.y && v1.z == v2.z;
    }
}
