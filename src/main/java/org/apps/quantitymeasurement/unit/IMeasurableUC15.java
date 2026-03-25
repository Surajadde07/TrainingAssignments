package org.apps.quantitymeasurement.unit;
public interface IMeasurableUC15 {

    double toBase(double value);
    double fromBase(double baseValue);

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException("Operation " + operation + " not supported");
        }
    }

    String getMeasurementType();
}