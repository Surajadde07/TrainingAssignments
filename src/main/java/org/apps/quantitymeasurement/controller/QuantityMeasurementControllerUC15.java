package org.apps.quantitymeasurement.controller;

import org.apps.quantitymeasurement.dto.QuantityDTOUC15;
import org.apps.quantitymeasurement.service.IQuantityMeasurementServiceUC15;

public class QuantityMeasurementControllerUC15 {

    private final IQuantityMeasurementServiceUC15 service;

    public QuantityMeasurementControllerUC15(IQuantityMeasurementServiceUC15 service) {
        this.service = service;
    }

    // ✅ RETURN VALUES (NOT VOID)

    public QuantityDTOUC15 convert(QuantityDTOUC15 input, String targetUnit) {
        return service.convert(input, targetUnit);
    }

    public boolean compare(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {
        return service.compare(q1, q2);
    }

    public QuantityDTOUC15 add(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {
        return service.add(q1, q2);
    }

    public QuantityDTOUC15 subtract(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {
        return service.subtract(q1, q2);
    }

    public double divide(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {
        return service.divide(q1, q2);
    }
}