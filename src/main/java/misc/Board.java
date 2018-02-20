package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {
    private final Chess[][] chesses;
    private final int size;

    private Board(int size) {
        chesses = new Chess[size][size];
        this.size = size;
    }

    public static Board createBoard(int size) {
        if (size > 0) {
            return new Board(size);
        } else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    public Chess[][] getChesses() {
        return chesses;
    }

    public void setChess(Point point, Chess chess) {
        chesses[point.getX()][point.getY()] = chess;
    }

    public boolean isSpotAvailable(Point point) {
        return chesses[point.getX()][point.getY()] == null;
    }

    public boolean hasValidMoves(Chess side) {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (chesses[x][y] == side.getOppositeChess()) {
                    HashSet<Point> points = getEmptySurroundingPoints(new Point(x, y));
                    for (Point p : points) {
                        HashSet<Point> possibleMoves = markChesses(p, side);
                        if (!possibleMoves.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    protected HashSet<Point> getEmptySurroundingPoints(Point point) {
        HashSet<Point> points = new HashSet<Point>();
        for (MarkingRule markingRule : getMarkingRules()) {
            Point p = markingRule.getNextPoint(point);
            if (p != null && chesses[p.getX()][p.getY()] == null) {
                points.add(p);
            }
        }
        return points;
    }

    private List<MarkingRule> getMarkingRules() {
        ArrayList<MarkingRule> markingRules = new ArrayList<>();
        markingRules.add(point -> getNextNorth(point));
        markingRules.add(point -> getNextNorthEast(point));
        markingRules.add(point -> getNextEast(point));
        markingRules.add(point -> getNextSouthEast(point));
        markingRules.add(point -> getNextSouth(point));
        markingRules.add(point -> getNextSouthWest(point));
        markingRules.add(point -> getNextWest(point));
        markingRules.add(point -> getNextNorthWest(point));
        return markingRules;
    }

    public HashSet<Point> markChesses(Point point, Chess chess) {
        HashSet<Point> points = new HashSet<>();
        points.addAll(markChessNorth(point, chess));
        points.addAll(markChessNorthEast(point, chess));
        points.addAll(markChessEast(point, chess));
        points.addAll(markChessSouthEast(point, chess));
        points.addAll(markChessSouth(point, chess));
        points.addAll(markChessSouthWest(point, chess));
        points.addAll(markChessWest(point, chess));
        points.addAll(markChessNorthWest(point, chess));
        return points;
    }

    protected HashSet<Point> markChessNorthWest(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextNorthWest(p));
    }

    protected HashSet<Point> markChessWest(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextWest(p));
    }

    protected HashSet<Point> markChessSouthWest(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextSouthWest(p));
    }

    protected HashSet<Point> markChessSouth(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextSouth(p));
    }

    protected HashSet<Point> markChessSouthEast(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextSouthEast(p));
    }

    protected HashSet<Point> markChessEast(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextEast(p));
    }

    protected HashSet<Point> markChessNorthEast(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextNorthEast(p));
    }

    protected HashSet<Point> markChessNorth(Point point, Chess chess) {
        return markChess(point, chess, p -> getNextNorth(p));
    }

    protected HashSet<Point> markChess(Point point, Chess chess, MarkingRule markingRule) {
        HashSet<Point> points = new HashSet<>();
        for (Point p = markingRule.getNextPoint(point); p != null; p = markingRule.getNextPoint(p)) {
            Chess chess1 = chesses[p.getX()][p.getY()];
            if (chess1 == chess.getOppositeChess()) {
                points.add(p);
            } else if (chess1 == chess) { // same side
                return points;
            } else {
                break;
            }
        }
        points.clear();
        return points;
    }

    public void flipSide(HashSet<Point> points, Chess side) {
        for (Point p : points) {
            chesses[p.getX()][p.getY()] = side;
        }
    }

    public void printResults() {
        int countX = 0;
        int countO = 0;
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                if (chesses[x][y] == Chess.O) {
                    countO++;
                } else if (chesses[x][y] == Chess.X) {
                    countX++;
                }
            }
        }
        if (countO > countX) {
            System.out.println("Player 'O' wins ( " + countO + " vs " + countX + " )");
        } else if (countX > countO) {
            System.out.println("Player 'X' wins ( " + countX + " vs " + countO + " )");
        } else {
            System.out.println("Draw game!");
        }
    }

    private interface MarkingRule {
        Point getNextPoint(Point point);
    }

    protected Point getNextNorth(Point point) {
        if (point.getY() > 0) {
            return new Point(point.getX(), point.getY() - 1);
        }
        return null;
    }

    protected Point getNextNorthEast(Point point) {
        if (point.getX() < getSize() - 1 && point.getY() > 0) {
            return new Point(point.getX() + 1, point.getY() - 1);
        }
        return null;
    }

    protected Point getNextEast(Point point) {
        if (point.getX() < getSize() - 1) {
            return new Point(point.getX() + 1, point.getY());
        }
        return null;
    }

    protected Point getNextSouthEast(Point point) {
        if (point.getX() < getSize() - 1 && point.getY() < getSize() - 1) {
            return new Point(point.getX() + 1, point.getY() + 1);
        }
        return null;
    }

    protected Point getNextSouth(Point point) {
        if (point.getY() < getSize() - 1) {
            return new Point(point.getX(), point.getY() + 1);
        }
        return null;
    }

    protected Point getNextSouthWest(Point point) {
        if (point.getX() > 0 && point.getY() < getSize() - 1) {
            return new Point(point.getX() - 1, point.getY() + 1);
        }
        return null;
    }

    protected Point getNextWest(Point point) {
        if (point.getX() > 0) {
            return new Point(point.getX() - 1, point.getY());
        }
        return null;
    }

    protected Point getNextNorthWest(Point point) {
        if (point.getX() > 0 && point.getY() > 0) {
            return new Point(point.getX() - 1, point.getY() - 1);
        }
        return null;
    }
}
