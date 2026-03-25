import org.apps.quantitymeasurement.controller.QuantityMeasurementControllerUC15;
import org.apps.quantitymeasurement.dto.QuantityDTOUC15;
import org.apps.quantitymeasurement.service.IQuantityMeasurementServiceUC15;
import org.apps.quantitymeasurement.service.QuantityMeasurementServiceImplUC15;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTestUC15 {

    private QuantityMeasurementControllerUC15 controller;

    @BeforeEach
    void setup() {
        IQuantityMeasurementServiceUC15 service = new QuantityMeasurementServiceImplUC15();

        controller = new QuantityMeasurementControllerUC15(service);
    }

    @Test
    void testService_CompareEquality_SameUnit_Success() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(10.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(10.0, "FEET", "LENGTH");

        assertTrue(controller.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_DifferentUnit_Success() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(0.0, "CELSIUS", "TEMPERATURE");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(32.0, "FAHRENHEIT", "TEMPERATURE");

        assertTrue(controller.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_CrossCategory_Error() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(10.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(10.0, "KILOGRAM", "WEIGHT");

        assertFalse(controller.compare(q1, q2));
    }

    // =========================
    // ✅ CONVERSION TESTS
    // =========================

    @Test
    void testService_Convert_Success() {
        QuantityDTOUC15 input = new QuantityDTOUC15(0.0, "CELSIUS", "TEMPERATURE");

        QuantityDTOUC15 result = controller.convert(input, "FAHRENHEIT");

        assertEquals(32.0, result.getValue(), 0.01);
    }

    @Test
    void testService_Convert_Length() {
        QuantityDTOUC15 input = new QuantityDTOUC15(12.0, "INCHES", "LENGTH");

        QuantityDTOUC15 result = controller.convert(input, "FEET");

        assertEquals(1.0, result.getValue(), 0.01);
    }

    // =========================
    // ✅ ADDITION TESTS
    // =========================

    @Test
    void testService_Add_Success() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(10.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(12.0, "INCHES", "LENGTH");

        QuantityDTOUC15 result = controller.add(q1, q2);

        assertEquals(11.0, result.getValue(), 0.01);
    }

    @Test
    void testService_Add_UnsupportedOperation_Error() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(100.0, "CELSIUS", "TEMPERATURE");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(50.0, "CELSIUS", "TEMPERATURE");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.add(q1, q2);
        });

        assertTrue(exception.getMessage().contains("Temperature"));
    }

    // =========================
    // ✅ SUBTRACTION TESTS
    // =========================

    @Test
    void testService_Subtract_Success() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(5.0, "LITRE", "VOLUME");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(2.0, "LITRE", "VOLUME");

        QuantityDTOUC15 result = controller.subtract(q1, q2);

        assertEquals(3.0, result.getValue(), 0.01);
    }

    // =========================
    // ✅ DIVISION TESTS
    // =========================

    @Test
    void testService_Divide_Success() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(20.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(2.0, "FEET", "LENGTH");

        double result = controller.divide(q1, q2);

        assertEquals(10.0, result, 0.01);
    }

    @Test
    void testService_Divide_ByZero_Error() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(20.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(0.0, "FEET", "LENGTH");

        assertThrows(RuntimeException.class, () -> {
            controller.divide(q1, q2);
        });
    }

    // =========================
    // ✅ INTEGRATION TESTS
    // =========================

    @Test
    void testIntegration_EndToEnd_LengthAddition() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(10.0, "FEET", "LENGTH");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(12.0, "INCHES", "LENGTH");

        QuantityDTOUC15 result = controller.add(q1, q2);

        assertEquals(11.0, result.getValue(), 0.01);
    }

    @Test
    void testIntegration_EndToEnd_TemperatureUnsupported() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(100.0, "CELSIUS", "TEMPERATURE");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(50.0, "CELSIUS", "TEMPERATURE");

        assertThrows(RuntimeException.class, () -> {
            controller.add(q1, q2);
        });
    }
}