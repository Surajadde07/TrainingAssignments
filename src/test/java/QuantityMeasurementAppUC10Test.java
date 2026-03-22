import org.apps.quantitymeasurement.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppUC10Test {

    @Test
    public void testLengthEquality() {
        QuantityUC10<LengthUnitUC10> feet =
                new QuantityUC10<>(1, LengthUnitUC10.FEET);

        QuantityUC10<LengthUnitUC10> inches =
                new QuantityUC10<>(12, LengthUnitUC10.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testWeightEquality() {
        QuantityUC10<WeightUnitUC10> kg =
                new QuantityUC10<>(1, WeightUnitUC10.KILOGRAM);

        QuantityUC10<WeightUnitUC10> gram =
                new QuantityUC10<>(1000, WeightUnitUC10.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    public void testLengthConversion() {
        QuantityUC10<LengthUnitUC10> feet =
                new QuantityUC10<>(1, LengthUnitUC10.FEET);

        QuantityUC10<LengthUnitUC10> result =
                feet.convertTo(LengthUnitUC10.INCHES);

        assertEquals(new QuantityUC10<>(12, LengthUnitUC10.INCHES), result);
    }

    @Test
    public void testWeightConversion() {
        QuantityUC10<WeightUnitUC10> kg =
                new QuantityUC10<>(1, WeightUnitUC10.KILOGRAM);

        QuantityUC10<WeightUnitUC10> result =
                kg.convertTo(WeightUnitUC10.GRAM);

        assertEquals(new QuantityUC10<>(1000, WeightUnitUC10.GRAM), result);
    }

    @Test
    public void testLengthAddition() {
        QuantityUC10<LengthUnitUC10> feet =
                new QuantityUC10<>(1, LengthUnitUC10.FEET);

        QuantityUC10<LengthUnitUC10> inches =
                new QuantityUC10<>(12, LengthUnitUC10.INCHES);

        QuantityUC10<LengthUnitUC10> result =
                feet.add(inches, LengthUnitUC10.FEET);

        assertEquals(new QuantityUC10<>(2, LengthUnitUC10.FEET), result);
    }

    @Test
    public void testWeightAddition() {
        QuantityUC10<WeightUnitUC10> kg =
                new QuantityUC10<>(1, WeightUnitUC10.KILOGRAM);

        QuantityUC10<WeightUnitUC10> gram =
                new QuantityUC10<>(1000, WeightUnitUC10.GRAM);

        QuantityUC10<WeightUnitUC10> result =
                kg.add(gram, WeightUnitUC10.KILOGRAM);

        assertEquals(new QuantityUC10<>(2, WeightUnitUC10.KILOGRAM), result);
    }

    @Test
    public void testCrossCategoryComparison() {
        QuantityUC10<LengthUnitUC10> length =
                new QuantityUC10<>(1, LengthUnitUC10.FEET);

        QuantityUC10<WeightUnitUC10> weight =
                new QuantityUC10<>(1, WeightUnitUC10.KILOGRAM);

        assertFalse(length.equals(weight));
    }
}