package org.apps.quantitymeasurement.unit;
public class QuantityUC15<U extends IMeasurableUC15> {

    private double value;
    private U unit;

    public QuantityUC15(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    public QuantityUC15<U> convertTo(U target) {
        double base = this.toBase();
        double converted = target.fromBase(base);
        return new QuantityUC15<>(converted, target);
    }

    public QuantityUC15<U> add(QuantityUC15<U> other) {
        unit.validateOperationSupport("ADD");
        double result = this.toBase() + other.toBase();
        return new QuantityUC15<>(unit.fromBase(result), unit);
    }

    public QuantityUC15<U> subtract(QuantityUC15<U> other) {
        unit.validateOperationSupport("SUBTRACT");
        double result = this.toBase() - other.toBase();
        return new QuantityUC15<>(unit.fromBase(result), unit);
    }

    public double divide(QuantityUC15<U> other) {
        if (other.toBase() == 0) {
            throw new RuntimeException("Cannot divide by zero");
        }
        unit.validateOperationSupport("DIVIDE");
        return this.toBase() / other.toBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityUC15<?> other)) return false;

        if (!unit.getMeasurementType().equals(other.unit.getMeasurementType())) {
            return false;
        }

        double base1 = this.toBase();
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }
}
