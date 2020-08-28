
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to a game of Rock[R,1] Paper[P,2] Scissors[S,3]");
		String  mode =  getValidChoice(input);
		
		if(mode.equals("1")) {
			System.out.println("\nPlayer VS Computer, Game on!");
			Game game = new Game("Player"); 	// Constructor with one Player and one Computer
			game.playGameOnePlayer();			
		} else {
			System.out.println("\nPlayer VS Player, Game on!");
			Game game = new Game("Player One", "Player Two"); 	// Constructor with two Players
			game.playGameTwoPlayer();
		}
		
		input.close();
	}
	
	static String getValidChoice(Scanner input) {

		System.out.println("Choose playing mode: "
				+ "\n1 - VS Computer"
				+ "\n2 - VS Other Player");
		System.out.print("Mode: ");
		String move = input.nextLine();

		// loop until a valid option has been entered
		while (!move.equals("1") && !move.equals("2")) {
			System.out.print("\nInvalid playing mode! Try again: ");
			move = input.nextLine();
		}

		return move;
	}
}
