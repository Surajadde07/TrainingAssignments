package org.apps.quantitymeasurement;

public enum WeightUnitUC14 implements IMeasurableUC14 {

    KILOGRAM(1000.0),
    GRAM(1.0);

    private final double factor;

    WeightUnitUC14(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double base) {
        return base / factor;
    }
}