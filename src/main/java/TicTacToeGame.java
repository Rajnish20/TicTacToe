import java.util.Arrays;

public class TicTacToeGame {
    public char[] createBoard() {
        char[] board = new char[9];
        Arrays.fill(board, ' ');
        return board;
    }

    public static void main(String[] args) {
        System.out.println("welcome to TicTacToe");
        TicTacToeGame ticTacToe = new TicTacToeGame();
        char[] board = ticTacToe.createBoard();
    }
}
