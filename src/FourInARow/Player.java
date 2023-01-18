package FourInARow;

import java.util.Scanner;

/* class Player():
    def __init__(self):
        self.name = ""
        self.number = ""

    def set_player(self , number):
        name = input(f"Enter Player {number} Name: ")
        self.name = name
        self.number = str(number)

    def get_name(self):
        return self.name
    
    def get_number(self):
        return self.number

    def make_move(self):
        column = int(input("Enter Column: "))
        
        return column

    def check_winner(self):
        return self.name
 */

public class Player {

    private String name;
    private String playerNumber;
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
