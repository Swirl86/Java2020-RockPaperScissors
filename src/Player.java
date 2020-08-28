import java.util.Scanner;

public class Player {
	// Values shall not change. Used for checks and print outs
		final static String ROCK = "Rock";
		final static String PAPER = "Paper";
		final static String SCISSORS = "Scissors";
		
		private Scanner input;
		private String playerName;
		private int score;
		
		// Every player has a name and a score
		public Player(String name) {
			input = new Scanner(System.in);
			playerName = name;
			score = 0;
		}
		
		public void addScore() {
			score += 1;
		}
		
		public int getScore() {
			return score;
		}
		
		public String getName() {
			return playerName;
		}
		
		public String getMove() {			
	        System.out.print("\nValid options are Rock[R,1] Paper[P,2] Scissors[S,3]");
	        return getValidMove(); 		// Make sure the move is valid
		}
		
		public String getValidMove() {

			System.out.print("\nEnter your move: ");
			String move = input.nextLine();

			// loop until a valid option has been entered
			while (conditionChecks(move.toLowerCase())) {  // Make everything lowerCase before check's
				System.out.println("\nInvalid option! Valid options are Rock[R,1] Paper[P,2] Scissors[S,3]");
				System.out.print("Enter your move: ");
				move = input.nextLine();
			}

			return getCorrectMoveName(move.toLowerCase()); 
		}
		
		/*
		 *  I made a separate method for the move checks, conditionChecks. 
		 *  It makes it easier to read and it handles both text and number input.
		 *  It takes the first char of what you enter and is not case sensitive. 
		 *  For a move e.g. Rock you can type rock, Rock, r, R, 1, 11111, Roke etc.
		 */
		public boolean conditionChecks(String value) {
			boolean invalid = false;
			// Avoid index out of range error when nothing is entered
			if(value.length() == 0) { 
				invalid = true;
			} else {
				invalid = value.charAt(0) != '1' && value.charAt(0) != '2' && value.charAt(0) != '3' &&
						value.charAt(0) != 'r' &&  value.charAt(0) != 'p' &&  value.charAt(0) != 's';
			}
			return invalid;
		}
		
		// Keep right text format for prints and checks
		public String getCorrectMoveName(String value) {
			String move = "";
			
			if (value.charAt(0) == '1' || value.charAt(0) == 'r') {
				move = ROCK;
			} else if (value.charAt(0) == '2' || value.charAt(0) == 'p') {
				move = PAPER;
			} else {
				move = SCISSORS;
			}
			return move;
		}
}
