package org.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityUC10<U extends IMeasurableUC10> {

    private final double value;
    private final U unit;

    public QuantityUC10(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private boolean compare(QuantityUC10<U> that) {
        return Math.abs(this.toBase() - that.toBase()) < 0.0001;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityUC10<?>)) return false;

        QuantityUC10<?> that = (QuantityUC10<?>) obj;

        // Prevent cross-category comparison
        if (!this.unit.getClass().equals(that.unit.getClass())) {
            return false;
        }

        QuantityUC10<U> other = (QuantityUC10<U>) that;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBase());
    }

    public QuantityUC10<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = toBase();
        double result = targetUnit.convertFromBaseUnit(base);

        return new QuantityUC10<>(round(result), targetUnit);
    }

    public QuantityUC10<U> add(QuantityUC10<U> other) {
        return add(other, this.unit);
    }

    public QuantityUC10<U> add(QuantityUC10<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityUC10<>(round(result), targetUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}