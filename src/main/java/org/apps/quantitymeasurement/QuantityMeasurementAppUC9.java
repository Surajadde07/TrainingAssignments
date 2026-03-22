package org.apps.quantitymeasurement;

public class QuantityMeasurementAppUC9 {

    public static boolean checkEquality(
            QuantityWeight w1,
            QuantityWeight w2) {

        return w1.equals(w2);
    }

    public static QuantityWeight convertWeight(
            QuantityWeight weight,
            WeightUnit toUnit) {

        return weight.convertTo(toUnit);
    }

    public static QuantityWeight addWeights(
            QuantityWeight w1,
            QuantityWeight w2) {

        return w1.add(w2);
    }

    public static QuantityWeight addWeights(
            QuantityWeight w1,
            QuantityWeight w2,
            WeightUnit targetUnit) {

        return w1.add(w2, targetUnit);
    }

    public static void main(String[] args) {

        QuantityWeight kg =
                new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000, WeightUnit.GRAM);

        System.out.println(checkEquality(kg, gram));

        System.out.println(convertWeight(kg, WeightUnit.POUND));

        System.out.println(addWeights(kg, gram));
    }
}