package org.apps.quantitymeasurement;

public interface IMeasurableUC14 {

    double toBase(double value);
    double fromBase(double baseValue);

    SupportsArithmeticUC14 supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
    }
}