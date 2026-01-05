public class Board {

    private Symbol[][] board;

    public Board() {
        this.board = new Symbol[3][3];
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
    }

    public Symbol[][] getBoard() {
        return board;
    }

    void set(int row, int col, Symbol symbol) {
        this.board[row][col] = symbol;
    }

    boolean valid(int row, int col) {
        return board[row][col] == Symbol.EMPTY;
    }

    boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean iswinner(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }


}
