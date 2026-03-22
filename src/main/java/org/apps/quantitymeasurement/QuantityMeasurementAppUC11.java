package org.apps.quantitymeasurement;

public class QuantityMeasurementAppUC11 {

    public static <U extends IMeasurableUC11> void demonstrateEquality(QuantityUC11<U> q1, QuantityUC11<U> q2) {
        System.out.println(q1 + " == " + q2 + " → " + q1.equals(q2));
    }

    public static <U extends IMeasurableUC11> void demonstrateConversion(QuantityUC11<U> q, U targetUnit) {
        System.out.println(q + " → " + q.convertTo(targetUnit));
    }

    public static <U extends IMeasurableUC11> void demonstrateAddition(QuantityUC11<U> q1, QuantityUC11<U> q2, U targetUnit) {
        System.out.println(q1 + " + " + q2 + " → " + q1.add(q2, targetUnit));
    }

    public static void main(String[] args) {

        // 🔹 LENGTH
        QuantityUC11<LengthUnitUC11> l1 = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<LengthUnitUC11> l2 = new QuantityUC11<>(12.0, LengthUnitUC11.INCHES);

        demonstrateEquality(l1, l2);
        demonstrateConversion(l1, LengthUnitUC11.INCHES);
        demonstrateAddition(l1, l2, LengthUnitUC11.FEET);

        // 🔹 WEIGHT
        QuantityUC11<WeightUnitUC11> w1 = new QuantityUC11<>(1.0, WeightUnitUC11.KILOGRAM);
        QuantityUC11<WeightUnitUC11> w2 = new QuantityUC11<>(1000.0, WeightUnitUC11.GRAM);

        demonstrateEquality(w1, w2);
        demonstrateConversion(w1, WeightUnitUC11.GRAM);
        demonstrateAddition(w1, w2, WeightUnitUC11.KILOGRAM);

        // 🔹 VOLUME (UC11 🔥)
        QuantityUC11<VolumeUnitUC11> v1 = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<VolumeUnitUC11> v2 = new QuantityUC11<>(1000.0, VolumeUnitUC11.MILLILITRE);
        QuantityUC11<VolumeUnitUC11> v3 = new QuantityUC11<>(1.0, VolumeUnitUC11.GALLON);

        demonstrateEquality(v1, v2);
        demonstrateConversion(v1, VolumeUnitUC11.MILLILITRE);
        demonstrateAddition(v1, v2, VolumeUnitUC11.LITRE);

        demonstrateEquality(v3, new QuantityUC11<>(3.78541, VolumeUnitUC11.LITRE));
        demonstrateAddition(v1, v3, VolumeUnitUC11.MILLILITRE);
    }
}
