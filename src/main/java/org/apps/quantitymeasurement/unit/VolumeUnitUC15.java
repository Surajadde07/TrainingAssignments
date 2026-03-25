package org.apps.quantitymeasurement.unit;

public enum VolumeUnitUC15 implements IMeasurableUC15 {

    LITRE(1.0),
    MILLILITRE(1.0 / 1000);

    private final double factor;

    VolumeUnitUC15(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    public String getMeasurementType() {
        return "volume";
    }
}
