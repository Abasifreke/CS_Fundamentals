package FourInARow;

import java.util.Scanner;
/* 
 *
class Game:
    def __init__(self):
        self.players = []
        self.p1 = None
        self.p2 = None
        self.board = None

    def set_up_game(self):
        self.players = [Player() , Player()]
        self.players[0].set_player("1")
        self.players[1].set_player("2")
        #self.p1 = Player()
        #self.p1.set_player("1")
        #self.p2 = Player()
        #self.p2.set_player("2")
        self.board = Board()
        self.board.board_setup()
        self.board.display()

    def winner(self , player):
        print(f"{player.get_name()} is the winner")   

    def player_turn(self , current_player):        
        column = current_player.make_move() 
        while not self.board.add_token(column, current_player.get_number()):
            self.board.add_token(column, current_player.get_number())
        self.board.display()

    def play(self):
        run = True
        self.set_up_game()
        current_player = 0
        while run:
            print(current_player)
            self.player_turn(self.players[current_player])
            if self.board.check_winner(self.players[current_player].get_number()):
                self.winner(self.players[current_player])
                run = False
            if current_player == 0:
                current_player = 1
            else:
                current_player = 0


    
       
 * 
 * */

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