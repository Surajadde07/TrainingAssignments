package org.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppUC9Test {

    @Test
    public void testEquality_KgToGram() {
        assertEquals(
                new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(1000, WeightUnit.GRAM)
        );
    }

    @Test
    public void testEquality_KgToPound() {
        assertEquals(
                new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(2.20462, WeightUnit.POUND)
        );
    }

    @Test
    public void testEquality_DifferentValue() {
        assertNotEquals(
                new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(2, WeightUnit.KILOGRAM)
        );
    }

    @Test
    public void testEquality_Null() {
        QuantityWeight q = new QuantityWeight(1, WeightUnit.KILOGRAM);
        assertNotEquals(q, null);
    }

    @Test
    public void testEquality_SameReference() {
        QuantityWeight q = new QuantityWeight(1, WeightUnit.KILOGRAM);
        assertEquals(q, q);
    }


    @Test
    public void testConversion_KgToGram() {
        assertEquals(
                new QuantityWeight(1000, WeightUnit.GRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM)
        );
    }

    @Test
    public void testConversion_PoundToKg() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(1, WeightUnit.KILOGRAM),
                result
        );
    }


    @Test
    public void testAddition_KgPlusKg() {
        assertEquals(
                new QuantityWeight(3, WeightUnit.KILOGRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2, WeightUnit.KILOGRAM))
        );
    }

    @Test
    public void testAddition_KgPlusGram() {
        assertEquals(
                new QuantityWeight(2, WeightUnit.KILOGRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM))
        );
    }

    @Test
    public void testAddition_WithTargetUnit() {
        assertEquals(
                new QuantityWeight(2000, WeightUnit.GRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM),
                                WeightUnit.GRAM)
        );
    }

    @Test
    public void testAddition_PoundPlusKg() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .add(new QuantityWeight(1, WeightUnit.KILOGRAM),
                                WeightUnit.POUND);

        assertEquals(
                new QuantityWeight(4.40924, WeightUnit.POUND),
                result
        );
    }

    @Test
    public void testZeroValue() {
        assertEquals(
                new QuantityWeight(0, WeightUnit.KILOGRAM),
                new QuantityWeight(0, WeightUnit.GRAM)
        );
    }

    @Test
    public void testNegativeValues() {
        assertEquals(
                new QuantityWeight(-1, WeightUnit.KILOGRAM),
                new QuantityWeight(-1000, WeightUnit.GRAM)
        );
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityWeight(1, null);
        });
    }
}