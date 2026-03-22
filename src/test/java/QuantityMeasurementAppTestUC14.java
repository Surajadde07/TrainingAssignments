package org.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTestUC14 {

    // =========================
    // 🔹 TEMPERATURE EQUALITY
    // =========================

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(0.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(32.0, TemperatureUnitUC14.FAHRENHEIT);

        assertTrue(t1.equals(t2));
    }

    @Test
    void testTemperatureEquality_Negative40() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(-40.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(-40.0, TemperatureUnitUC14.FAHRENHEIT);

        assertTrue(t1.equals(t2));
    }

    @Test
    void testTemperatureInequality() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(50.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(60.0, TemperatureUnitUC14.CELSIUS);

        assertFalse(t1.equals(t2));
    }

    // =========================
    // 🔹 TEMPERATURE CONVERSION
    // =========================

    @Test
    void testCelsiusToFahrenheit() {
        QuantityUC14<TemperatureUnitUC14> t =
                new QuantityUC14<>(100.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> result =
                t.convertTo(TemperatureUnitUC14.FAHRENHEIT);

        assertEquals(212.0, result.getValue(), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        QuantityUC14<TemperatureUnitUC14> t =
                new QuantityUC14<>(32.0, TemperatureUnitUC14.FAHRENHEIT);

        QuantityUC14<TemperatureUnitUC14> result =
                t.convertTo(TemperatureUnitUC14.CELSIUS);

        assertEquals(0.0, result.getValue(), 0.01);
    }

    // =========================
    // 🔹 UNSUPPORTED OPERATIONS
    // =========================

    @Test
    void testTemperatureAddition_NotSupported() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(100.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(50.0, TemperatureUnitUC14.CELSIUS);

        assertThrows(UnsupportedOperationException.class, () -> t1.add(t2));
    }

    @Test
    void testTemperatureSubtraction_NotSupported() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(100.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(50.0, TemperatureUnitUC14.CELSIUS);

        assertThrows(UnsupportedOperationException.class, () -> t1.subtract(t2));
    }

    @Test
    void testTemperatureDivision_NotSupported() {
        QuantityUC14<TemperatureUnitUC14> t1 =
                new QuantityUC14<>(100.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<TemperatureUnitUC14> t2 =
                new QuantityUC14<>(50.0, TemperatureUnitUC14.CELSIUS);

        assertThrows(UnsupportedOperationException.class, () -> t1.divide(t2));
    }

    // =========================
    // 🔹 CROSS CATEGORY TEST
    // =========================

    @Test
    void testTemperatureVsLength_NotEqual() {
        QuantityUC14<TemperatureUnitUC14> temp =
                new QuantityUC14<>(100.0, TemperatureUnitUC14.CELSIUS);

        QuantityUC14<LengthUnitUC14> length =
                new QuantityUC14<>(100.0, LengthUnitUC14.FEET);

        assertFalse(temp.equals(length));
    }

    // =========================
    // 🔹 REGRESSION TESTS (UC13 SHOULD STILL WORK)
    // =========================

    @Test
    void testLengthAddition() {
        QuantityUC14<LengthUnitUC14> l1 =
                new QuantityUC14<>(10.0, LengthUnitUC14.FEET);

        QuantityUC14<LengthUnitUC14> l2 =
                new QuantityUC14<>(12.0, LengthUnitUC14.INCH);

        QuantityUC14<LengthUnitUC14> result = l1.add(l2);

        assertEquals(11.0, result.getValue(), 0.01);
    }

    @Test
    void testVolumeSubtraction() {
        QuantityUC14<VolumeUnitUC14> v1 =
                new QuantityUC14<>(5.0, VolumeUnitUC14.LITRE);

        QuantityUC14<VolumeUnitUC14> v2 =
                new QuantityUC14<>(2.0, VolumeUnitUC14.LITRE);

        QuantityUC14<VolumeUnitUC14> result = v1.subtract(v2);

        assertEquals(3.0, result.getValue(), 0.01);
    }

    @Test
    void testDivision() {
        QuantityUC14<LengthUnitUC14> l1 =
                new QuantityUC14<>(10.0, LengthUnitUC14.FEET);

        QuantityUC14<LengthUnitUC14> l2 =
                new QuantityUC14<>(2.0, LengthUnitUC14.FEET);

        double result = l1.divide(l2);

        assertEquals(5.0, result, 0.01);
    }
}