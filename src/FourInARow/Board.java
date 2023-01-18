package FourInARow;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private String[][] board;
    private Scanner scanner = new Scanner(System.in);

    public void boardSetUp() {
        // TODO: Add validation to check that the number of rows and cols provided is
        // greater than 4.
        // Can provide error messaging.
        System.out.println("------ Board Set up -------");
        System.out.println("Number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Number of cols: ");
        int cols = scanner.nextInt();
        this.board = new String[rows][cols];

        // initialize empty board with dashes (-)
        for (String[] row : board) {
            Arrays.fill(row, "-");
        }
    }

    public void printBoard() {
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean columnFull(int col) {
        if (this.board[0][col].equals("-")) {
            return false;
        }
        return true;
    }

    public boolean boardFull() {
        for (int i = 0; i < this.board[0].length; i++) {
            if (!columnFull(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean addToken(int colToAddToken, String playerName) {
        if (columnFull(colToAddToken)) {
            // could return exception here.
            System.out.println("Column Full");
            return false;
        }

        int rowToAddToken = board.length - 1;

        while (rowToAddToken >= 0) {
            if (board[rowToAddToken][colToAddToken].equals("-")) {
                board[rowToAddToken][colToAddToken] = playerName;
                return true;
            } else {
                rowToAddToken -= 1;
            }
        }

        return false;
    }

    public boolean checkIfPlayerIsTheWinner(String playerNumber) {
        if (checkHorizontal(playerNumber)) {
            return true;
        } else if (checkVertical(playerNumber)) {
            return true;
        } else if (checkRightDiagonal(playerNumber)) {
            return true;
        } else if (checkLeftDiagonal(playerNumber)) {
            return true;
        }
        return false;
    }

    public boolean checkVertical(String playerNumber) {
        for (int col = 0; col < board[0].length; col++) {
            // length - 3 here cos we are comparing 4 in a row items
            for (int row = 0; row < board.length - 3; row++) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col] == board[row + 1][col]
                            && board[row][col] == board[row + 2][col]
                            && board[row][col] == board[row + 3][col]) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean checkHorizontal(String playerNumber) {
        for (int col = 0; col < board[0].length - 3; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col] == board[row][col + 1]
                            && board[row][col] == board[row][col + 2]
                            && board[row][col] == board[row][col + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkRightDiagonal(String playerNumber) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col] == board[row + 1][col + 1]
                            && board[row][col] == board[row + 2][col + 2]
                            && board[row][col] == board[row + 3][col + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkLeftDiagonal(String playerNumber) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = board[0].length - 1; col > 2; col--) {
                if (board[row][col].equals(playerNumber)) {
                    if (board[row][col] == board[row + 1][col - 1]
                            && board[row][col] == board[row + 2][col - 2]
                            && board[row][col] == board[row + 3][col - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
