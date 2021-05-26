import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    Scanner scanner = new Scanner(System.in);
    public char[] createBoard() {
        char[] board = new char[9];
        Arrays.fill(board, ' ');
        return board;
    }

    public char chooseLetter() {
        System.out.println("Choose 'X' or '0'");
        return scanner.next().charAt(0);

    }

    public static void main(String[] args) {
        System.out.println("welcome to TicTacToe");
        TicTacToeGame ticTacToe = new TicTacToeGame();
        char[] board = ticTacToe.createBoard();
        char computer;
        char player = ticTacToe.chooseLetter();
        computer = (player == 'X') ? '0' : 'X';
        System.out.println("Player : " + player);
        System.out.println("Computer : " + computer);
    }
}
