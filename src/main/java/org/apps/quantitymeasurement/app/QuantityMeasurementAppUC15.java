package org.apps.quantitymeasurement.app;

import org.apps.quantitymeasurement.controller.QuantityMeasurementControllerUC15;
import org.apps.quantitymeasurement.dto.QuantityDTOUC15;

import org.apps.quantitymeasurement.service.QuantityMeasurementServiceImplUC15;

public class QuantityMeasurementAppUC15 {

    public static void main(String[] args) {

        var service = new QuantityMeasurementServiceImplUC15();
        var controller = new QuantityMeasurementControllerUC15(service);

        // Test 1: Compare same temperature in different units
        QuantityDTOUC15 t1 = new QuantityDTOUC15(0, "CELSIUS", "temperature");
        QuantityDTOUC15 t2 = new QuantityDTOUC15(32, "FAHRENHEIT", "temperature");
        boolean isEqual = controller.compare(t1, t2);
        System.out.println("Test 1 - Compare 0°C with 32°F: " + isEqual);

        // Test 2: Convert Celsius to Fahrenheit
        QuantityDTOUC15 convertResult = controller.convert(t1, "FAHRENHEIT");
        System.out.println("Test 2 - Convert 0°C to Fahrenheit: " + convertResult.getValue() + "°F");

        // Test 3: Add length measurements
        QuantityDTOUC15 l1 = new QuantityDTOUC15(10, "FEET", "length");
        QuantityDTOUC15 l2 = new QuantityDTOUC15(12, "INCHES", "length");
        QuantityDTOUC15 addResult = controller.add(l1, l2);
        System.out.println("Test 3 - Add 10 FEET + 12 INCHES: " + addResult.getValue() + " " + addResult.getUnit());

        // Test 4: Subtract volume measurements
        QuantityDTOUC15 v1 = new QuantityDTOUC15(5, "LITRE", "volume");
        QuantityDTOUC15 v2 = new QuantityDTOUC15(2, "LITRE", "volume");
        QuantityDTOUC15 subtractResult = controller.subtract(v1, v2);
        System.out.println("Test 4 - Subtract 5 LITRE - 2 LITRE: " + subtractResult.getValue() + " " + subtractResult.getUnit());

        // Test 5: Divide length measurements
        QuantityDTOUC15 d1 = new QuantityDTOUC15(20, "FEET", "length");
        QuantityDTOUC15 d2 = new QuantityDTOUC15(2, "FEET", "length");
        double divideResult = controller.divide(d1, d2);
        System.out.println("Test 5 - Divide 20 FEET by 2 FEET: " + divideResult);
    }
}