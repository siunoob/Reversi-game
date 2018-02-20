package misc;

public class Chess {
    public enum SIDE {O, X}

    public static final Chess O = new Chess(SIDE.O);
    public static final Chess X = new Chess(SIDE.X);

    private final SIDE side;

    private Chess(SIDE side) {
        this.side = side;
    }

    public SIDE getSide() {
        return side;
    }

    public Chess getOppositeChess() {
        if (side == SIDE.O) {
            return Chess.X;
        } else {
            return Chess.O;
        }
    }

    @Override
    public String toString() {
        return "Chess{" +
                "side=" + side +
                '}';
    }
}
