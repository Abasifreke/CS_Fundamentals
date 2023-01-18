package FourInARow;

import java.util.Scanner;

public class Player {

    private String name;
    private String playerNumber;
    // Question: should scanner be static or not?
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, String playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPlayerNumber() {
        return this.playerNumber;
    }

    public int makeMove() {
        System.out.println("Make your move. What column do you want to put a token in?");
        int column = scanner.nextInt();
        return column;
    }

    public String checkWinner() {
        return this.name;
    }

    // TODO: override tostring method to print out a proper Player
    public String toString() {
        return ("Player " + playerNumber + " is " + name);
    }
}
