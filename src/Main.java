import java.util.Scanner;

public class Main {
    final static int boardWidth = 3, boardHeight = 3;
    static char[][] board = new char[boardWidth][boardHeight];
    static char currentPlayer = 'X';
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int maxOfPlays = boardWidth * boardHeight;
        for (int i = 0; i <= maxOfPlays; i++) {
            makeMove();
            showBoard();
            if (verifyWinner()) {
                System.out.print("Player " + currentPlayer + " Win!");
                break;
            }
            switchPlayer();
        }
    }

    public static boolean verifyWinner() {
        for (int i = 0; i < boardWidth; i++) {
            // straight line
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                return true;
            }
            if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                return true;
            }
            // vertical line
            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                return true;
            }
            if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                return true;
            }
        }

        // top left to bottom right
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            return true;
        }
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            return true;
        }
        // bottom left to top right
        if (board[2][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            return true;
        }
        if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
            return true;
        }

        return false;
    }

    public static void makeMove() {
        System.out.println("Player " + currentPlayer + " turn.");

        int row, column;

        do {

            do {
                System.out.print("enter a row: ");
                row = scan.nextInt();
            } while (row < 1 || row > 3);

            do {
                System.out.print("enter a column: ");
                column = scan.nextInt();
            } while (column < 1 || column > 3);

        } while (board[row - 1][column - 1] == 'X' || board[row - 1][column - 1] == 'O');

        board[row - 1][column - 1] = currentPlayer;
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void showBoard() {
        for (int row = 0; row < boardWidth; row++) {
            for (int column = 0; column < boardHeight; column++) {
                if (column == 0 || column == 2) {
                    System.out.print("| " + board[row][column] + " |");
                } else {
                    System.out.print(" " + board[row][column] + " ");
                }
            }
            System.out.println();
        }
    }
}