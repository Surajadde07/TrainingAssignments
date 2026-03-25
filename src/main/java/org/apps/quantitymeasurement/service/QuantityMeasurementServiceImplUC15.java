package org.apps.quantitymeasurement.service;

import org.apps.quantitymeasurement.dto.QuantityDTOUC15;
import org.apps.quantitymeasurement.unit.*;

public class QuantityMeasurementServiceImplUC15 implements IQuantityMeasurementServiceUC15 {

    private IMeasurableUC15 resolve(String type, String unit) {
        return switch (type.toLowerCase()) {
            case "length" -> LengthUnitUC15.valueOf(unit);
            case "temperature" -> TemperatureUnitUC15.valueOf(unit);
            case "volume" -> VolumeUnitUC15.valueOf(unit);
            default -> throw new RuntimeException("Invalid type");
        };
    }

    @Override
    public boolean compare(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {
        try {
            var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
            var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

            var a = new QuantityUC15<>(q1.getValue(), u1);
            var b = new QuantityUC15<>(q2.getValue(), u2);

            return a.equals(b);
        } catch (RuntimeException e) {
            // If types are not compatible, return false
            return false;
        }
    }

    @Override
    public QuantityDTOUC15 convert(QuantityDTOUC15 input, String targetUnit) {

        var u1 = resolve(input.getMeasurementType(), input.getUnit());
        var target = resolve(input.getMeasurementType(), targetUnit);

        var result = new QuantityUC15<>(input.getValue(), u1).convertTo(target);

        return new QuantityDTOUC15(result.getValue(), targetUnit, input.getMeasurementType());
    }

    @Override
    public QuantityDTOUC15 add(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        var result = new QuantityUC15<>(q1.getValue(), u1)
                .add(new QuantityUC15<>(q2.getValue(), u2));

        return new QuantityDTOUC15(result.getValue(), q1.getUnit(), q1.getMeasurementType());
    }

    @Override
    public QuantityDTOUC15 subtract(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        var result = new QuantityUC15<>(q1.getValue(), u1)
                .subtract(new QuantityUC15<>(q2.getValue(), u2));

        return new QuantityDTOUC15(result.getValue(), q1.getUnit(), q1.getMeasurementType());
    }

    @Override
    public double divide(QuantityDTOUC15 q1, QuantityDTOUC15 q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        return new QuantityUC15<>(q1.getValue(), u1)
                .divide(new QuantityUC15<>(q2.getValue(), u2));
    }
}