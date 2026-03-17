package UC2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InchTest {

    @Test
    void testEquality_SameValue() {
        assertTrue(new Inch(1.0).equals(new Inch(1.0)));
    }

    @Test
    void testEquality_DifferentValue() {
        assertFalse(new Inch(1.0).equals(new Inch(2.0)));
    }

    @Test
    void testEquality_NullComparison() {
        assertFalse(new Inch(1.0).equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Inch i = new Inch(1.0);
        assertTrue(i.equals(i));
    }
}