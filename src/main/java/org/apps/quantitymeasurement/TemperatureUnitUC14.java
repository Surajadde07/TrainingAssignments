package org.apps.quantitymeasurement;

public enum TemperatureUnitUC14 implements IMeasurableUC14 {

    CELSIUS {
        public double toBase(double value) {
            return value;
        }

        public double fromBase(double base) {
            return base;
        }
    },

    FAHRENHEIT {
        public double toBase(double value) {
            return (value - 32) * 5.0 / 9.0;
        }

        public double fromBase(double base) {
            return (base * 9.0 / 5.0) + 32;
        }
    };

    private final SupportsArithmeticUC14 supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation"
        );
    }
}