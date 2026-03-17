package UC1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeetMeasurementEqualityTest {

    @Test
    void testEquality_SameValue() {
        FeetMeasurementEquality.Feet f1 = new FeetMeasurementEquality.Feet(1.0);
        FeetMeasurementEquality.Feet f2 = new FeetMeasurementEquality.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        FeetMeasurementEquality.Feet f1 = new FeetMeasurementEquality.Feet(1.0);
        FeetMeasurementEquality.Feet f2 = new FeetMeasurementEquality.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        FeetMeasurementEquality.Feet f1 = new FeetMeasurementEquality.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        FeetMeasurementEquality.Feet f1 = new FeetMeasurementEquality.Feet(1.0);

        assertFalse(f1.equals("abc"));
    }

    @Test
    void testEquality_SameReference() {
        FeetMeasurementEquality.Feet f1 = new FeetMeasurementEquality.Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}