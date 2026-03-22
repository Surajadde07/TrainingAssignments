package org.apps.quantitymeasurement;

public enum WeightUnitUC11 implements IMeasurableUC11 {
    KILOGRAM(1.0),
    GRAM(0.001),
    TONNE(1000.0);

    private final double conversionFactor;

    WeightUnitUC11(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    public String getUnitName() {
        return this.name();
    }
}
