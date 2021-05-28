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

    public boolean winCheck(char[] board, char letter) {

        /*
         *Created 2D array to store the winning positions
         */
        int[][] winningPlaces = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        /*
         *Loop to check any winning conditions satisfies
         * if yes then return false to finish the game
         */
        for (int[] win : winningPlaces) {
            if (board[win[0]] == letter && board[win[1]] == letter && board[win[2]] == letter)
                return false;
        }

        /*
         *To Check whether game is tied or not
         */
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
        int[][] winningPlaces = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int[] win : winningPlaces) {
            if (tempBoard[win[0]] == mark && tempBoard[win[1]] == mark && tempBoard[win[2]] == mark)
                return true;
        }
        return false;
    }

    public boolean winMove(int location, char[] board, char mark) {
        char[] tempBoard = new char[board.length];
        System.arraycopy(board, 0, tempBoard, 0, board.length);
        tempBoard[location] = mark;
        return winning(tempBoard, mark);
    }

    public char[] cpuInput(char[] board, char player, char computer) {
        /*
         *Checking If computer can win or not
         */
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ' && winMove(i, board, computer)) {
                board[i] = computer;
                return board;
            }
        }

        /*
         *Checking if opponent is winning then block
         */
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ' && winMove(i, board, player)) {
                board[i] = computer;
                return board;
            }
        }

        /*
         *Check if any of the corners available then move to that position
         */
        int[] corners = {0, 2, 6, 8};
        for(int i = 0; i < 4; i++)
        {
            if(board[i] == ' ')
            {
                board[corners[i]] = computer;
                return board;
            }
        }

        /*
         * if centre is available then move to centre
         */
        if (board[4] == ' ') {
            board[4] = computer;
            return board;
        }

        /*
         *Checking if any of sides available then move to that position
         */
        int[] sides = {1, 3, 5, 7};
        for(int i = 0; i < 4; i++)
        {
            if(board[sides[i]] == ' ')
            {
                board[i] = computer;
                return board;
            }
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println("welcome to TicTacToe");
        Scanner myScan = new Scanner(System.in);
        char ans;
        do {
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
            boolean play = true;
            while (play) {
                if (options == 0) {
                    board = ticTacToe.userInput(board, player);
                    ticTacToe.showBoard(board);
                    System.out.println("******************************");
                    play = ticTacToe.winCheck(board, player);
                    if (play) {
                        board = ticTacToe.cpuInput(board, player, computer);
                        ticTacToe.showBoard(board);
                        System.out.println("******************************");
                        play = ticTacToe.winCheck(board, computer);
                        if (!play)
                            System.out.println("Computer Won");
                    } else
                        System.out.println("Player Won");
                } else {
                    board = ticTacToe.cpuInput(board, player, computer);
                    ticTacToe.showBoard(board);
                    System.out.println("******************************");
                    play = ticTacToe.winCheck(board, computer);
                    if (play) {
                        board = ticTacToe.userInput(board, player);
                        ticTacToe.showBoard(board);
                        System.out.println("******************************");
                        play = ticTacToe.winCheck(board, player);
                        if (!play)
                            System.out.println("You Won");
                    } else
                        System.out.println("Computer Won");
                }
            }
            System.out.println("Game Over");
            System.out.println("Do you want to play again(y/n) ?");
            ans = myScan.next().charAt(0);
        } while (ans == 'Y' || ans == 'y');

    }
}
