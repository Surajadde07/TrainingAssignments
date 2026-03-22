package org.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityUC11<U extends IMeasurableUC11> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 0.0001;

    public QuantityUC11(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof QuantityUC11)) return false;

        QuantityUC11<?> other = (QuantityUC11<?>) obj;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    public QuantityUC11<U> convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        converted = Math.round(converted * 100.0) / 100.0;

        return new QuantityUC11<>(converted, targetUnit);
    }

    public QuantityUC11<U> add(QuantityUC11<U> other) {
        return add(other, this.unit);
    }

    public QuantityUC11<U> add(QuantityUC11<U> other, U targetUnit) {
        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;
        double converted = targetUnit.convertFromBaseUnit(sum);

        converted = Math.round(converted * 100.0) / 100.0;

        return new QuantityUC11<>(converted, targetUnit);
    }

    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Objects.hash(Math.round(base / EPSILON));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}
