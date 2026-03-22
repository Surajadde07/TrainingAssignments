package org.apps.quantitymeasurement;

public class QuantityMeasurementAppUC10 {

    public static <U extends IMeasurableUC10> boolean demonstrateEquality(
            QuantityUC10<U> q1,
            QuantityUC10<U> q2) {

        return q1.equals(q2);
    }

    public static <U extends IMeasurableUC10> QuantityUC10<U> demonstrateConversion(
            QuantityUC10<U> q,
            U targetUnit) {

        return q.convertTo(targetUnit);
    }

    public static <U extends IMeasurableUC10> QuantityUC10<U> demonstrateAddition(
            QuantityUC10<U> q1,
            QuantityUC10<U> q2,
            U targetUnit) {

        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        // LENGTH
        QuantityUC10<LengthUnitUC10> l1 =
                new QuantityUC10<>(1, LengthUnitUC10.FEET);

        QuantityUC10<LengthUnitUC10> l2 =
                new QuantityUC10<>(12, LengthUnitUC10.INCHES);

        System.out.println(demonstrateAddition(l1, l2, LengthUnitUC10.FEET));

        // WEIGHT
        QuantityUC10<WeightUnitUC10> w1 =
                new QuantityUC10<>(1, WeightUnitUC10.KILOGRAM);

        QuantityUC10<WeightUnitUC10> w2 =
                new QuantityUC10<>(1000, WeightUnitUC10.GRAM);

        System.out.println(demonstrateAddition(w1, w2, WeightUnitUC10.KILOGRAM));
    }
}