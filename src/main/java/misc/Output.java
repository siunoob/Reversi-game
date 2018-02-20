package misc;

public class Output {
    public static void printBoard(Board board) {
        System.out.print(getBoardString(board));
    }

    private static String getBoardString(Board board) {
        StringBuilder sb = new StringBuilder();
        int size = board.getSize();
        Chess[][] chesses = board.getChesses();
        for (int y = 0; y < size; y++) {
            sb.append((y + 1) + " ");
            for (int x = 0; x < size; x++) {
                sb.append(printUnit(chesses[x][y]));
            }
            sb.append("\n");
        }
        sb.append("  abcdefgh\n");
        return sb.toString();
    }

    private static char printUnit(Chess chess) {
        if (chess == Chess.O) {
            return 'O';
        } else if (chess == Chess.X) {
            return 'X';
        } else {
            return '-';
        }
    }
}
