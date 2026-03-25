package org.apps.quantitymeasurement.model;

import org.apps.quantitymeasurement.unit.*;

public class QuantityModelUC15<U extends IMeasurableUC15> {

    private double value;
    private U unit;

    public QuantityModelUC15(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public U getUnit() { return unit; }
}