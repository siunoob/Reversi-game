package misc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BoardTest {

    @Test
    @Parameters({
            "1,true",
            "8,true",
            "0,false",
            "-1,false"
    })
    public void createBoard(int size, boolean canCreate) {
        Board board = Board.createBoard(size);
        assertEquals(canCreate, board != null);
        if (canCreate) {
            Chess[][] board1 = board.getChesses();
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    assertNull(board1[i][j]);
                }
            }
        }
    }

    @Test
    public void isSpotAvailable() {
        Board board = Board.createBoard(1);
        assertTrue(board.isSpotAvailable(new Point(0, 0)));

        board.setChess(new Point(0, 0), Chess.X);
        assertFalse(board.isSpotAvailable(new Point(0, 0)));
    }

    @Test
    @Parameters({
            "0,0,-1,-1",
            "1,0,-1,-1",
            "7,0,-1,-1",
            "3,1,3,0",
            "3,4,3,3",
            "2,5,2,4",
    })
    public void getNextNorth(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextNorth(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,0,-1,-1",
            "1,0,-1,-1",
            "7,0,-1,-1",
            "7,1,-1,-1",
            "7,7,-1,-1",
            "3,4,4,3",
            "2,5,3,4",
            "2,7,3,6",
            "6,1,7,0",
    })
    public void getNextNorthEast(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextNorthEast(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,0,1,0",
            "1,0,2,0",
            "7,0,-1,-1",
            "7,1,-1,-1",
            "7,7,-1,-1",
            "6,0,7,0",
            "3,4,4,4",
            "2,5,3,5",
            "2,7,3,7",
    })
    public void getNextEast(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextEast(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "7,0,-1,-1",
            "7,1,-1,-1",
            "7,7,-1,-1",
            "0,7,-1,-1",
            "5,7,-1,-1",
            "3,4,4,5",
            "2,5,3,6",
            "5,6,6,7",
            "6,6,7,7",
    })
    public void getNextSouthEast(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextSouthEast(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,7,-1,-1",
            "5,7,-1,-1",
            "7,7,-1,-1",
            "3,4,3,5",
            "2,5,2,6",
            "5,6,5,7",
            "6,6,6,7",
    })
    public void getNextSouth(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextSouth(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,7,-1,-1",
            "5,7,-1,-1",
            "7,7,-1,-1",
            "0,4,-1,-1",
            "0,0,-1,-1",
            "3,4,2,5",
            "2,5,1,6",
            "5,6,4,7",
            "7,0,6,1",
            "1,6,0,7",
    })
    public void getNextSouthWest(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextSouthWest(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,7,-1,-1",
            "0,4,-1,-1",
            "0,0,-1,-1",
            "1,0,0,0",
            "5,7,4,7",
            "7,7,6,7",
            "3,4,2,4",
            "2,5,1,5",
            "5,6,4,6",
            "7,0,6,0",
    })
    public void getNextWest(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextWest(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    @Parameters({
            "0,0,-1,-1",
            "1,0,-1,-1",
            "7,0,-1,-1",
            "0,4,-1,-1",
            "0,7,-1,-1",
            "1,1,0,0",
            "5,7,4,6",
            "7,7,6,6",
            "3,4,2,3",
            "2,5,1,4",
            "5,6,4,5",
    })
    public void getNextNorthWest(int x, int y, int expx, int expy) {
        Board board = Board.createBoard(8);
        Point actual = board.getNextNorthWest(new Point(x, y));
        if (expx == -1 && expy == -1) {
            assertNull(actual);
        } else {
            assertEquals(new Point(expx, expy), actual);
        }
    }

    @Test
    public void markChessNorthWest() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessNorthWest(new Point(5, 5), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(2, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);
    }

    @Test
    public void markChessNorthWest1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.O);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessNorthWest(new Point(5, 5), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(4, 4), Chess.X);
    }

    @Test
    public void markChessNorthWest2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessNorthWest(new Point(5, 5), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessNorthWest3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.O);

        HashSet<Point> points = board.markChessNorthWest(new Point(5, 5), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessWest() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 1), Chess.X);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(4, 1), Chess.X);

        HashSet<Point> points = board.markChessWest(new Point(5, 1), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(2, 1), Chess.X);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(4, 1), Chess.X);
    }

    @Test
    public void markChessWest2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 1), Chess.X);
        board.setChess(new Point(3, 1), Chess.O);
        board.setChess(new Point(4, 1), Chess.X);

        HashSet<Point> points = board.markChessWest(new Point(5, 1), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(4, 1), Chess.X);
    }

    @Test
    public void markChessWest3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 1), Chess.X);
        board.setChess(new Point(4, 1), Chess.X);

        HashSet<Point> points = board.markChessWest(new Point(5, 1), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessWest4() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 1), Chess.O);
        board.setChess(new Point(2, 1), Chess.X);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(4, 1), Chess.O);

        HashSet<Point> points = board.markChessWest(new Point(5, 1), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouthWest() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 7), Chess.O);
        board.setChess(new Point(2, 6), Chess.X);
        board.setChess(new Point(3, 5), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessSouthWest(new Point(5, 3), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(2, 6), Chess.X);
        board.setChess(new Point(3, 5), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);
    }

    @Test
    public void markChessSouthWest2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 7), Chess.O);
        board.setChess(new Point(2, 6), Chess.X);
        board.setChess(new Point(3, 5), Chess.O);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessSouthWest(new Point(5, 3), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(4, 4), Chess.X);
    }

    @Test
    public void markChessSouthWest3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 7), Chess.O);
        board.setChess(new Point(2, 6), Chess.X);
        board.setChess(new Point(4, 4), Chess.X);

        HashSet<Point> points = board.markChessSouthWest(new Point(5, 3), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouthWest4() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(1, 7), Chess.O);
        board.setChess(new Point(2, 6), Chess.X);
        board.setChess(new Point(3, 5), Chess.X);
        board.setChess(new Point(4, 4), Chess.O);

        HashSet<Point> points = board.markChessSouthWest(new Point(5, 3), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouth() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(5, 5), Chess.X);
        board.setChess(new Point(5, 4), Chess.X);
        board.setChess(new Point(5, 3), Chess.X);

        HashSet<Point> points = board.markChessSouth(new Point(5, 2), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(5, 5), Chess.X);
        board.setChess(new Point(5, 4), Chess.X);
        board.setChess(new Point(5, 3), Chess.X);
    }

    @Test
    public void markChessSouth1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(5, 5), Chess.X);
        board.setChess(new Point(5, 4), Chess.O);
        board.setChess(new Point(5, 3), Chess.X);

        HashSet<Point> points = board.markChessSouth(new Point(5, 2), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(5, 3), Chess.X);
    }

    @Test
    public void markChessSouth2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(5, 5), Chess.X);
        board.setChess(new Point(5, 3), Chess.X);

        HashSet<Point> points = board.markChessSouth(new Point(5, 2), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouth3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(5, 5), Chess.X);
        board.setChess(new Point(5, 4), Chess.X);
        board.setChess(new Point(5, 3), Chess.O);

        HashSet<Point> points = board.markChessSouth(new Point(5, 2), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouthEast() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(4, 5), Chess.X);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessSouthEast(new Point(1, 2), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(4, 5), Chess.X);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);
    }

    @Test
    public void markChessSouthEast1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(4, 5), Chess.X);
        board.setChess(new Point(3, 4), Chess.O);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessSouthEast(new Point(1, 2), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(2, 3), Chess.X);
    }

    @Test
    public void markChessSouthEast2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(4, 5), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessSouthEast(new Point(1, 2), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessSouthEast3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 6), Chess.O);
        board.setChess(new Point(4, 5), Chess.X);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(2, 3), Chess.O);

        HashSet<Point> points = board.markChessSouthEast(new Point(1, 2), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessEast() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessEast(new Point(1, 3), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);
    }

    @Test
    public void markChessEast1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(3, 3), Chess.O);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessEast(new Point(1, 3), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(2, 3), Chess.X);
    }

    @Test
    public void markChessEast2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(2, 3), Chess.X);

        HashSet<Point> points = board.markChessEast(new Point(1, 3), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessEast3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);
        board.setChess(new Point(2, 3), Chess.O);

        HashSet<Point> points = board.markChessEast(new Point(1, 3), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessNorthEast() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 4), Chess.X);
        board.setChess(new Point(3, 5), Chess.X);
        board.setChess(new Point(2, 6), Chess.X);

        HashSet<Point> points = board.markChessNorthEast(new Point(1, 7), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        board.setChess(new Point(4, 4), Chess.X);
        board.setChess(new Point(3, 5), Chess.X);
        board.setChess(new Point(2, 6), Chess.X);
    }

    @Test
    public void markChessNorthEast1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 4), Chess.X);
        board.setChess(new Point(3, 5), Chess.O);
        board.setChess(new Point(2, 6), Chess.X);

        HashSet<Point> points = board.markChessNorthEast(new Point(1, 7), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        board.setChess(new Point(2, 6), Chess.X);
    }

    @Test
    public void markChessNorthEast2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(5, 3), Chess.O);
        board.setChess(new Point(4, 4), Chess.X);
        board.setChess(new Point(2, 6), Chess.X);

        HashSet<Point> points = board.markChessNorthEast(new Point(1, 7), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessNorth() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 0), Chess.O);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(3, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);

        HashSet<Point> points = board.markChessNorth(new Point(3, 4), Chess.O);
        assertNotNull(points);
        assertEquals(3, points.size());
        assertTrue(points.contains(new Point(3, 1)));
        assertTrue(points.contains(new Point(3, 2)));
        assertTrue(points.contains(new Point(3, 3)));
    }

    @Test
    public void markChessNorth1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 0), Chess.O);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(3, 2), Chess.X);
        board.setChess(new Point(3, 4), Chess.X);

        HashSet<Point> points = board.markChessNorth(new Point(3, 5), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void markChessNorth2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 0), Chess.O);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(3, 2), Chess.O);
        board.setChess(new Point(3, 3), Chess.X);

        HashSet<Point> points = board.markChessNorth(new Point(3, 4), Chess.O);
        assertNotNull(points);
        assertEquals(1, points.size());
        assertTrue(points.contains(new Point(3, 3)));
    }

    @Test
    public void markChessNorth3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 0), Chess.O);
        board.setChess(new Point(3, 1), Chess.X);
        board.setChess(new Point(3, 2), Chess.X);
        board.setChess(new Point(3, 3), Chess.X);

        HashSet<Point> points = board.markChessNorth(new Point(4, 4), Chess.O);
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void hasValidMoves() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 3), Chess.O);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.O);

        assertTrue(board.hasValidMoves(Chess.X));
        assertTrue(board.hasValidMoves(Chess.O));
    }

    @Test
    public void hasValidMoves1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(0, 1), Chess.X);
        board.setChess(new Point(0, 2), Chess.X);
        board.setChess(new Point(1, 0), Chess.X);
        board.setChess(new Point(1, 1), Chess.X);
        board.setChess(new Point(1, 2), Chess.X);
        board.setChess(new Point(2, 0), Chess.X);
        board.setChess(new Point(2, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.O);
        Output.printBoard(board);

        assertTrue(board.hasValidMoves(Chess.X));
        assertTrue(board.hasValidMoves(Chess.O));
    }

    @Test
    public void getEmptySurroundingPoints() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(3, 3), Chess.O);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.O);

        HashSet<Point> points = board.getEmptySurroundingPoints(new Point(3, 3));
        assertNotNull(points);
        assertEquals(5, points.size());
        assertTrue(points.contains(new Point(2, 2)));
        assertTrue(points.contains(new Point(3, 2)));
        assertTrue(points.contains(new Point(4, 2)));
        assertTrue(points.contains(new Point(2, 3)));
        assertTrue(points.contains(new Point(2, 4)));
    }

    @Test
    public void getEmptySurroundingPoints1() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(0, 0), Chess.O);
        board.setChess(new Point(0, 1), Chess.X);
        board.setChess(new Point(1, 0), Chess.X);
        board.setChess(new Point(1, 1), Chess.O);

        HashSet<Point> points = board.getEmptySurroundingPoints(new Point(0, 0));
        assertNotNull(points);
        assertEquals(0, points.size());
    }

    @Test
    public void getEmptySurroundingPoints2() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(0, 0), Chess.O);
        board.setChess(new Point(0, 1), Chess.X);
        board.setChess(new Point(1, 0), Chess.X);
        board.setChess(new Point(1, 1), Chess.O);

        HashSet<Point> points = board.getEmptySurroundingPoints(new Point(1, 1));
        assertNotNull(points);
        assertEquals(5, points.size());
        assertTrue(points.contains(new Point(2, 0)));
        assertTrue(points.contains(new Point(2, 1)));
        assertTrue(points.contains(new Point(2, 2)));
        assertTrue(points.contains(new Point(0, 2)));
        assertTrue(points.contains(new Point(1, 2)));
    }

    @Test
    public void getEmptySurroundingPoints3() {
        Board board = Board.createBoard(8);
        board.setChess(new Point(0, 1), Chess.X);
        board.setChess(new Point(0, 2), Chess.X);
        board.setChess(new Point(1, 0), Chess.X);
        board.setChess(new Point(1, 1), Chess.X);
        board.setChess(new Point(1, 2), Chess.X);
        board.setChess(new Point(2, 0), Chess.X);
        board.setChess(new Point(2, 1), Chess.O);
        board.setChess(new Point(2, 2), Chess.O);

        HashSet<Point> points = board.getEmptySurroundingPoints(new Point(1, 1));
        assertNotNull(points);
        assertEquals(1, points.size());
        assertTrue(points.contains(new Point(0, 0)));
    }
}