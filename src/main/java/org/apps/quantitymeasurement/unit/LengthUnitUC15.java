package org.apps.quantitymeasurement.unit;

public enum LengthUnitUC15 implements IMeasurableUC15 {

    FEET(1.0),
    INCHES(1.0 / 12);

    private final double factor;

    LengthUnitUC15(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    public String getMeasurementType() {
        return "length";
    }
}