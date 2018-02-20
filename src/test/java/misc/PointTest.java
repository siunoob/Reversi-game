package misc;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTest {

    @Test
    public void equals() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(5, 6);
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p1));
        assertTrue(p2.equals(p2));

        Point p3 = new Point(5, 6);
        Point p4 = new Point(1, 1);
        assertFalse(p3.equals(p4));
        assertTrue(p3.equals(p3));
        assertTrue(p4.equals(p4));
    }
}