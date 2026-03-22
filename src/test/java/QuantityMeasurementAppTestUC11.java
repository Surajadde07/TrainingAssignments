import org.apps.quantitymeasurement.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC11 {

    private static final double EPSILON = 0.0001;


    @Test
    void testLengthEquality_FeetToInches() {
        QuantityUC11<LengthUnitUC11> q1 = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<LengthUnitUC11> q2 = new QuantityUC11<>(12.0, LengthUnitUC11.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testLengthConversion() {
        QuantityUC11<LengthUnitUC11> q = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<LengthUnitUC11> result = q.convertTo(LengthUnitUC11.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testLengthAddition() {
        QuantityUC11<LengthUnitUC11> q1 = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<LengthUnitUC11> q2 = new QuantityUC11<>(12.0, LengthUnitUC11.INCHES);

        QuantityUC11<LengthUnitUC11> result = q1.add(q2, LengthUnitUC11.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }


    @Test
    void testWeightEquality_KgToGram() {
        QuantityUC11<WeightUnitUC11> q1 = new QuantityUC11<>(1.0, WeightUnitUC11.KILOGRAM);
        QuantityUC11<WeightUnitUC11> q2 = new QuantityUC11<>(1000.0, WeightUnitUC11.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testWeightConversion() {
        QuantityUC11<WeightUnitUC11> q = new QuantityUC11<>(1.0, WeightUnitUC11.KILOGRAM);
        QuantityUC11<WeightUnitUC11> result = q.convertTo(WeightUnitUC11.GRAM);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testWeightAddition() {
        QuantityUC11<WeightUnitUC11> q1 = new QuantityUC11<>(1.0, WeightUnitUC11.KILOGRAM);
        QuantityUC11<WeightUnitUC11> q2 = new QuantityUC11<>(1000.0, WeightUnitUC11.GRAM);

        QuantityUC11<WeightUnitUC11> result = q1.add(q2, WeightUnitUC11.KILOGRAM);

        assertEquals(2.0, result.getValue(), EPSILON);
    }


    @Test
    void testVolumeEquality_LitreToMillilitre() {
        QuantityUC11<VolumeUnitUC11> q1 = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<VolumeUnitUC11> q2 = new QuantityUC11<>(1000.0, VolumeUnitUC11.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testVolumeEquality_LitreToGallon() {
        QuantityUC11<VolumeUnitUC11> q1 = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<VolumeUnitUC11> q2 = new QuantityUC11<>(0.264172, VolumeUnitUC11.GALLON);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testVolumeConversion_LitreToMillilitre() {
        QuantityUC11<VolumeUnitUC11> q = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<VolumeUnitUC11> result = q.convertTo(VolumeUnitUC11.MILLILITRE);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testVolumeConversion_GallonToLitre() {
        QuantityUC11<VolumeUnitUC11> q = new QuantityUC11<>(1.0, VolumeUnitUC11.GALLON);
        QuantityUC11<VolumeUnitUC11> result = q.convertTo(VolumeUnitUC11.LITRE);

        assertEquals(3.79, result.getValue(), EPSILON);
    }

    @Test
    void testVolumeAddition_LitrePlusMillilitre() {
        QuantityUC11<VolumeUnitUC11> q1 = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<VolumeUnitUC11> q2 = new QuantityUC11<>(1000.0, VolumeUnitUC11.MILLILITRE);

        QuantityUC11<VolumeUnitUC11> result = q1.add(q2, VolumeUnitUC11.LITRE);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testVolumeAddition_WithGallon() {
        QuantityUC11<VolumeUnitUC11> q1 = new QuantityUC11<>(1.0, VolumeUnitUC11.GALLON);
        QuantityUC11<VolumeUnitUC11> q2 = new QuantityUC11<>(3.78541, VolumeUnitUC11.LITRE);

        QuantityUC11<VolumeUnitUC11> result = q1.add(q2, VolumeUnitUC11.GALLON);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    // =========================
    // 🔹 GENERIC BEHAVIOR TESTS
    // =========================

    @Test
    void testCrossCategoryComparison_LengthVsWeight() {
        QuantityUC11<LengthUnitUC11> length = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<WeightUnitUC11> weight = new QuantityUC11<>(1.0, WeightUnitUC11.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void testCrossCategoryComparison_VolumeVsLength() {
        QuantityUC11<VolumeUnitUC11> volume = new QuantityUC11<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC11<LengthUnitUC11> length = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);

        assertFalse(volume.equals(length));
    }

    @Test
    void testConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityUC11<>(1.0, null);
        });
    }

    @Test
    void testConstructor_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityUC11<>(Double.NaN, LengthUnitUC11.FEET);
        });
    }

    @Test
    void testToString() {
        QuantityUC11<LengthUnitUC11> q = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        assertEquals("Quantity(1.0, FEET)", q.toString());
    }

    @Test
    void testHashCodeConsistency() {
        QuantityUC11<LengthUnitUC11> q1 = new QuantityUC11<>(1.0, LengthUnitUC11.FEET);
        QuantityUC11<LengthUnitUC11> q2 = new QuantityUC11<>(12.0, LengthUnitUC11.INCHES);

        assertEquals(q1.hashCode(), q2.hashCode());
    }
}