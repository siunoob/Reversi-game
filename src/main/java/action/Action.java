package action;

import reversi.Reversi;

public abstract class Action {
    public abstract void performAction(Reversi reversi);

    public abstract Action getNextAction();
}
