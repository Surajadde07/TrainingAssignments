package UC2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeetTest {

    @Test
    void testEquality_SameValue() {
        assertTrue(new Feet(1.0).equals(new Feet(1.0)));
    }

    @Test
    void testEquality_DifferentValue() {
        assertFalse(new Feet(1.0).equals(new Feet(2.0)));
    }

    @Test
    void testEquality_NullComparison() {
        assertFalse(new Feet(1.0).equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Feet f = new Feet(1.0);
        assertTrue(f.equals(f));
    }
}