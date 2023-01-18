package FourInARow;

import java.util.InputMismatchException;
import java.util.Scanner;

import FourInARow.Exceptions.ColumnFullException;
import FourInARow.Exceptions.InvalidMoveException;

public class Game {

    private Player[] players;
    private Board board;
    private static Scanner scanner = new Scanner(System.in);

    public Game() {
        this.players = new Player[2];
        this.board = new Board();
    }

    public void setUpGame() {
        //TODO for students - Could reuse some exceptions here. 
        System.out.println("Enter player 1's name: ");
        players[0] = new Player(scanner.nextLine(), "1");
        System.out.println("Enter player 2's name: ");
        players[1] = new Player(scanner.nextLine(), "2");
        this.board.boardSetUp();
        this.board.printBoard();
    }

    public void printWinner(Player player) {
        System.out.println(player.getName() + " is the winner");
    }

    public void playerTurn(Player currentPlayer) {
        try {
            int col = currentPlayer.makeMove();
            while (!board.addToken(col, currentPlayer.getPlayerNumber())) {
                board.addToken(col, currentPlayer.getPlayerNumber());
            }
            board.printBoard();
        } 
        // If you think functions calling themselves sounds interesting, 
        // make sure you check out the recursion challenge activities elsewhere in this course.
        catch (InvalidMoveException invalidMoveException) {
            System.out.print("Retry: ");
            System.out.println(invalidMoveException.getMessage());
            playerTurn(currentPlayer);
        } catch (InputMismatchException invalidInputMismatchException) {
            System.out.print("Please provide a valid value for column");
            playerTurn(currentPlayer);
        } catch (ColumnFullException columnFullException) {
            System.out.println(columnFullException.getMessage());
            playerTurn(currentPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        boolean noWinner = true;
        this.setUpGame();
        int currentPlayerIndex = 0;

        while (noWinner) {
            if (board.boardFull()) {
                System.out.println("Board is now full. Game Ends.");
                return;
            }

            Player currentPlayer = players[currentPlayerIndex];
            // Override default tostring for Player class
            System.out.println("It is player " + currentPlayer.getPlayerNumber() + "'s turn. " + currentPlayer);
            playerTurn(currentPlayer);
            if (board.checkIfPlayerIsTheWinner(currentPlayer.getPlayerNumber())) {
                printWinner(currentPlayer);
                noWinner = false;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            }
        }
    }

}