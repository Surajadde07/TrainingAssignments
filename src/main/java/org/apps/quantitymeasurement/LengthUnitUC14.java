package org.apps.quantitymeasurement;

public enum LengthUnitUC14 implements IMeasurableUC14 {

    FEET(12.0),
    INCH(1.0);

    private final double factor;

    LengthUnitUC14(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double base) {
        return base / factor;
    }
}