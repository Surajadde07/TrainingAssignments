package org.apps.quantitymeasurement;

public class QuantityUC14<U extends IMeasurableUC14> {

    private final double value;
    private final U unit;

    public QuantityUC14(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof QuantityUC14<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass())) return false;

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        System.out.println("base1 = " + base1);
        System.out.println("base2 = " + base2);
        return Math.abs(base1 - base2) < 0.0001;
    }


    public QuantityUC14<U> convertTo(U targetUnit) {
        double base = unit.toBase(value);
        double converted = targetUnit.fromBase(base);
        return new QuantityUC14<>(round(converted), targetUnit);
    }


    private double performBaseArithmetic(QuantityUC14<U> other, ArithmeticOperationUC14 op) {

        // Validate
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");

        // FIRST check if operation is allowed (UC14 rule)
        unit.validateOperationSupport(op.name());

        // THEN check category
        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement types");

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        return op.apply(base1, base2);
    }

    public QuantityUC14<U> add(QuantityUC14<U> other) {
        double result = performBaseArithmetic(other, ArithmeticOperationUC14.ADD);
        return new QuantityUC14<>(round(unit.fromBase(result)), unit);
    }

    public QuantityUC14<U> subtract(QuantityUC14<U> other) {
        double result = performBaseArithmetic(other, ArithmeticOperationUC14.SUBTRACT);
        return new QuantityUC14<>(round(unit.fromBase(result)), unit);
    }

    public double divide(QuantityUC14<U> other) {
        return performBaseArithmetic(other, ArithmeticOperationUC14.DIVIDE);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }


    public double getValue() {
        return value;
    }
}