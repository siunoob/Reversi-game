package action;

import misc.Board;
import misc.Chess;
import misc.Output;
import misc.Point;
import reversi.Reversi;

import java.util.HashSet;

public class Player extends Action {
    private Player opponent;
    private Chess side;

    public Player(Chess side) {
        this.side = side;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    @Override
    public void performAction(Reversi reversi) {
        Board board = reversi.getBoard();
        if (board.hasValidMoves(side)) {
            boolean isTurnCompleted = false;
            while (!isTurnCompleted) {
                Point nextMove = reversi.getInput().getNextMove(side);
                if (board.isSpotAvailable(nextMove)) {
                    HashSet<Point> points = board.markChesses(nextMove, side);
                    if (!points.isEmpty()) {
                        board.setChess(nextMove, side);
                        board.flipSide(points, side);
                        Output.printBoard(board);
                        isTurnCompleted = true;
                    }
                }
                if (!isTurnCompleted) {
                    System.out.println("Invalid move. Please try again.");
                }
            }
        } else {
            System.out.println("No further moves available");
            board.printResults();
            opponent = null;
        }
    }

    @Override
    public Action getNextAction() {
        return opponent;
    }
}
