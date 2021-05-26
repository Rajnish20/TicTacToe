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


    public void showBoard(char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("----------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("----------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public char[] userInput(char[] board, char user) {
        int input = 0;
        do {
            System.out.println("Choose the number 1-9");
            int location = scanner.nextInt();
            for (int i = 0; i < board.length; i++) {
                if (i == location - 1 && board[i] == ' ') {
                    board[i] = user;
                    input = 1;
                    break;
                }
            }
            if (input == 0)
                System.out.println("Please Enter correct input");
        } while (input == 0);
        return board;

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
        ticTacToe.showBoard(board);
        board = ticTacToe.userInput(board, player);
    }
}
