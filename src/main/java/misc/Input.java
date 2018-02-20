package misc;

import java.util.Scanner;

public class Input {
    private Scanner reader;

    public Input() {
        reader = new Scanner(System.in);
    }

    public void close() {
        reader.close();
    }

    public static Point normalizeInput(String inputStr) {
        if (inputStr != null && inputStr.length() == 2) { //assume size=8 only
            int x, y;
            char c0 = inputStr.charAt(0);
            char c1 = inputStr.charAt(1);
            x = parseX(c0);
            y = parseY(c1);
            if (x == -1 && y == -1) {
                x = parseX(c1);
                y = parseY(c0);
            }

            if (x != -1 && y != -1) {
                return new Point(x, y);
            }
        }
        return null;
    }

    protected static int parseX(char c) {
        if (c >= 'a' && c <= 'h') {
            return c - 'a';
        }
        return -1;
    }

    protected static int parseY(char c) {
        if (c >= '1' && c <= '8') {
            return c - '1';
        }
        return -1;
    }

    public Point getNextMove(Chess side) {
        Point nextMove = null;
        while (nextMove == null) {
            System.out.println();
            System.out.print("Player '" + side.getSide().name() + "' move: ");
            String userIn = reader.next();

            nextMove = normalizeInput(userIn);
            if (nextMove == null) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
        }
        return nextMove;
    }
}
