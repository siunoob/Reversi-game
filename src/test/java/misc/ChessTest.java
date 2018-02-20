package misc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ChessTest {

    private Object getOppositeSideParams() {
        return new Object[]{
                new Object[]{Chess.X, Chess.O},
                new Object[]{Chess.O, Chess.X}
        };
    }

    @Test
    @Parameters(method = "getOppositeSideParams")
    public void getOppositeSide(Chess chess, Chess opposite) {
        Assert.assertEquals(opposite, chess.getOppositeChess());
    }
}