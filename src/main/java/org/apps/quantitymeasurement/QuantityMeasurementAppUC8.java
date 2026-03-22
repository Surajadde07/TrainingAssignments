package org.apps.quantitymeasurement;

public class QuantityMeasurementAppUC8 {

    public static boolean checkEquality(QuantityLength q1, QuantityLength q2) {
        return q1.equals(q2);
    }

    public static QuantityLength convert(
            QuantityLength q,
            LengthUnit toUnit) {

        return q.convertTo(toUnit);
    }

    public static QuantityLength add(
            QuantityLength q1,
            QuantityLength q2,
            LengthUnit targetUnit) {

        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result =
                add(q1, q2, LengthUnit.FEET);

        System.out.println(result);
    }
}