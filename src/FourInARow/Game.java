package FourInARow;

import java.util.Scanner;

public class Game {

    private Player[] players;
    private Board board;
    private static Scanner scanner = new Scanner(System.in);

    public Game() {
        this.players = new Player[2];
        this.board = new Board();
    }

    public void setUpGame() {
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
        int col = currentPlayer.makeMove();
        while (!board.addToken(col, currentPlayer.getPlayerNumber())) {
            board.addToken(col, currentPlayer.getPlayerNumber());
        }
        board.printBoard();
    }

    public void play() {
        boolean noWinner = true;

        this.setUpGame();
        int currentPlayerIndex = 0;

        while (noWinner) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer);
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