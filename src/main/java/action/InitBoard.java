package action;

import misc.Board;
import misc.Chess;
import misc.Output;
import misc.Point;
import reversi.Reversi;

public class InitBoard extends Action {
    private final Action startingPlayer;

    public InitBoard(Action startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    @Override
    public void performAction(Reversi reversi) {
        Board board = reversi.getBoard();
        board.setChess(new Point(3, 3), Chess.O);
        board.setChess(new Point(3, 4), Chess.X);
        board.setChess(new Point(4, 3), Chess.X);
        board.setChess(new Point(4, 4), Chess.O);

        Output.printBoard(board);
    }

    @Override
    public Action getNextAction() {
        return startingPlayer;
    }
}
