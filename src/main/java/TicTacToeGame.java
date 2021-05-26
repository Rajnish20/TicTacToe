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

    public boolean winCheck(char[] board, char player, char computer) {
        if ((board[0] == player && board[1] == player && board[2] == player) || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player) || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player) || (board[2] == player && board[5] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player) || (board[2] == player && board[4] == player && board[6] == player)) {
            System.out.println("You won");
            return false;
        }
        if ((board[0] == computer && board[1] == computer && board[2] == computer) || (board[3] == computer && board[4] == computer && board[5] == computer)
                || (board[6] == computer && board[7] == computer && board[8] == computer) || (board[0] == computer && board[3] == computer && board[6] == computer)
                || (board[1] == computer && board[4] == computer && board[7] == computer) || (board[2] == computer && board[5] == computer && board[8] == computer)
                || (board[0] == computer && board[4] == computer && board[8] == computer) || (board[2] == computer && board[4] == computer && board[6] == computer)) {
            System.out.println("Computer won");
            return false;
        }
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Match Tied");
            return false;
        }
        return true;
    }

    public boolean winning(char[] tempBoard, char mark) {
        return (tempBoard[0] == mark && tempBoard[1] == mark && tempBoard[2] == mark) || (tempBoard[3] == mark && tempBoard[4] == mark && tempBoard[5] == mark)
                || (tempBoard[6] == mark && tempBoard[7] == mark && tempBoard[8] == mark) || (tempBoard[0] == mark && tempBoard[3] == mark && tempBoard[6] == mark)
                || (tempBoard[1] == mark && tempBoard[4] == mark && tempBoard[7] == mark) || (tempBoard[2] == mark && tempBoard[5] == mark && tempBoard[8] == mark)
                || (tempBoard[0] == mark && tempBoard[4] == mark && tempBoard[8] == mark) || (tempBoard[2] == mark && tempBoard[4] == mark && tempBoard[6] == mark);
    }

    public boolean winMove(int location, char[] board, char mark) {
        char[] tempBoard = new char[board.length];
        System.arraycopy(board, 0, tempBoard, 0, board.length);
        tempBoard[location] = mark;
        return winning(tempBoard, mark);
    }

    public char[] cpuInput(char[] board, char player, char computer) {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ' && winMove(i, board, computer)) {
                board[i] = computer;
                return board;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ' && winMove(i, board, player)) {
                board[i] = computer;
                return board;
            }
        }
        if (board[0] == ' ') {
            board[0] = computer;
            return board;
        }
        if (board[2] == ' ') {
            board[2] = computer;
            return board;
        }
        if (board[6] == ' ') {
            board[6] = computer;
            return board;
        }
        if (board[8] == ' ') {
            board[8] = computer;
            return board;
        }
        if (board[4] == ' ') {
            board[4] = computer;
            return board;
        }
        if (board[1] == ' ') {
            board[1] = computer;
            return board;
        }
        if (board[3] == ' ') {
            board[3] = computer;
            return board;
        }
        if (board[5] == ' ') {
            board[5] = computer;
            return board;
        }
        if (board[7] == ' ') {
            board[7] = computer;
            return board;
        }
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
        int options = (int) (Math.random() * 2);
        if (options == 0) {
            System.out.println("You will play first");
        } else {
            System.out.println("Computer will play first");
        }

    }
}
