
public class Game {
	// Values shall not change. Used for checks and print outs
	final static String ROCK = "Rock";
	final static String PAPER = "Paper";
	final static String SCISSORS = "Scissors";

	private Player firstPlayer; 	
	private Player secondPlayer; 	
	private Player computer;	
	
	public Game(String fpName) { // Player VS Computer
		firstPlayer = new Player(fpName);
		computer = new Computer(); 
	}
	
	// Two constructors for two different game mode's
	
	public Game(String fpName, String spName) { // Player VS Player
		firstPlayer = new Player(fpName);
		secondPlayer = new Player(spName);
	}
	
	public void playGameOnePlayer() {
		
		// Run until some one gets 3 points
		while (firstPlayer.getScore() != 3 && computer.getScore() != 3) {
			
			/* Method's startOnePlayerRound and startTwoPlayerRound gets the Rock/Paper/Scissors
			 move from both opponents.Then use method getWinnerMove to compare the opponents 
			 moves to see if there is a winning move or if it is a tie */
			String winner = startOnePlayerRound();
			
			if (winner.equals("fp")) {
				firstPlayer.addScore();
			} else if (winner.equals("sp")) {
				computer.addScore();
			} else { // It is a tie
				firstPlayer.addScore();
				computer.addScore();
			}
			System.out.println("Current Score: " + firstPlayer.getScore() + " - " + computer.getScore());
		}
		
		// Game is over. Check if there is a winner or if it is a tie
		if (firstPlayer.getScore() == computer.getScore()) {
			System.out.println("\nIt is a tie!");
		} else if (firstPlayer.getScore() > computer.getScore()) {
			System.out.println("\nYou are the winner!");
		} else {
			System.out.println("\nComputer winns!");
		}
	}

	// Same as playGameOnePlayer but here there are two Player's and not a Computer 
	public void playGameTwoPlayer() {		
		// Run until some one gets 3 points
		while (firstPlayer.getScore() != 3 && secondPlayer.getScore() != 3) {

			String winner = startTwoPlayerRound();

			if (winner.equals("fp")) {
				firstPlayer.addScore();
			} else if (winner.equals("sp")) {
				secondPlayer.addScore();
			} else { // It is a tie
				firstPlayer.addScore();
				secondPlayer.addScore();
			}
			System.out.println("Current Score: " + firstPlayer.getScore() + " - " + secondPlayer.getScore());
		}

		if (firstPlayer.getScore() == secondPlayer.getScore()) {
			System.out.println("\nIt is a tie!");
		} else if (firstPlayer.getScore() > secondPlayer.getScore()) {
			System.out.println("\n" + firstPlayer.getName() + " winns the game!");
		} else {
			System.out.println("\n" + secondPlayer.getName() + " winns the game!");
		}
	}

	public String startOnePlayerRound() {

		// Get user move and generate the computers move
		String fp = firstPlayer.getMove();
		String comp = computer.getMove();
		
		System.out.print(fp + " VS " + comp + " : ");

		return getWinnerMove(fp, comp); // Send back winner information to add correct score(s)
	}

	public String startTwoPlayerRound() {

		// Get both user's moves
		System.out.print("\n" + firstPlayer.getName() + "'s turn!");
		String fp = firstPlayer.getMove();
	
		System.out.print("\n" + secondPlayer.getName() + "'s turn!");
		String sp = secondPlayer.getMove();

		System.out.print(fp + " VS " + sp + " : ");

		return getWinnerMove(fp, sp);
	}
	
	// This method takes the two given moves and compare them to find the
	// winning move or if it is a tie. Sending back a String with winner information.
	public String getWinnerMove(String firstMove, String secondMove) {
		String winner = "";

		if (firstMove.equals(secondMove)) {
			System.out.println("It is a tie! - both win!");
			winner = "both";
		} else if (firstMove.equals(ROCK)) {
			if (secondMove.equals(PAPER)) {
				System.out.println("Paper beats rock!");
				winner = "sp";
			} else if (secondMove.equals(SCISSORS)) {
				System.out.println("Rock beats scissor!");
				winner = "fp";
			}
		} else if (firstMove.equals(PAPER)) {
			if (secondMove.equals(ROCK)) {
				System.out.println("Paper beats rock!");
				winner = "fp";
			} else if (secondMove.equals(SCISSORS)) {
				System.out.println("Scissors beats paper!");
				winner = "sp";
			}
		} else if (firstMove.equals(SCISSORS)) {
			if (secondMove.equals(ROCK)) {
				System.out.println("Rock beats scissors!");
				winner = "sp";
			} else if (secondMove.equals(PAPER)) {
				System.out.println("Scissors beats paper!");
				winner = "fp";
			}
		}

		return winner;
	}
}
