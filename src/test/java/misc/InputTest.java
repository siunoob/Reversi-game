package misc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class InputTest {

    @Test
    @Parameters({
            "1a,0,0",
            "a1,0,0",
            "8a,0,7",
            "a8,0,7",
            "1h,7,0",
            "h1,7,0",
            "8h,7,7",
            "h8,7,7",
            "4f,5,3",
            "88,-1,-1",
            "aa,-1,-1",
            "8A,-1,-1",
            "AA,-1,-1",
            "1a1,-1,-1",
            "1,-1,-1",
    })
    public void normalizeInput(String input, int x, int y) {
        Point actual = Input.normalizeInput(input);
        if (x > 0 && y > 0) {

            Point expected = new Point(x, y);
        }
    }

    @Test
    @Parameters({
            "a,0",
            "b,1",
            "h,7",
            "i,-1",
            "A,-1",
            "H,-1",

    })
    public void parseX(char c, int expected) {
        Assert.assertEquals(expected, Input.parseX(c));
    }

    @Test
    @Parameters({
            "1,0",
            "2,1",
            "8,7",
            "0,-1",
            "9,-1",
            "a,-1",
            "A,-1",
    })
    public void parseY(char c, int expected) {
        Assert.assertEquals(expected, Input.parseY(c));
    }
}