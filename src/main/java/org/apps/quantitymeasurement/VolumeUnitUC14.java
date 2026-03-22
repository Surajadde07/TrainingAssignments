package org.apps.quantitymeasurement;

public enum VolumeUnitUC14 implements IMeasurableUC14 {

    LITRE(1000.0),
    MILLILITRE(1.0);

    private final double factor;

    VolumeUnitUC14(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double base) {
        return base / factor;
    }
}