package org.apps.quantitymeasurement.service;

import org.apps.quantitymeasurement.dto.QuantityDTOUC15;

public interface IQuantityMeasurementServiceUC15 {

    QuantityDTOUC15 convert(QuantityDTOUC15 input, String targetUnit);

    boolean compare(QuantityDTOUC15 q1, QuantityDTOUC15 q2);

    QuantityDTOUC15 add(QuantityDTOUC15 q1, QuantityDTOUC15 q2);

    QuantityDTOUC15 subtract(QuantityDTOUC15 q1, QuantityDTOUC15 q2);

    double divide(QuantityDTOUC15 q1, QuantityDTOUC15 q2);
}