
public class Computer extends Player{
	
	// The computer will have a name and score like the player
	public Computer() {
		super("Computer"); 	// Default name
	}
	
	// This method overrides getMove() of Player 
    @Override
	public String getMove() {
		
		int randomNum = ((int) (Math.random() * 3)) + 1; 	// Random generate value, 1-3
		String move = "";
		
		// Rock = 1, Paper = 2, Scissors = 3
		if (randomNum == 1) {
			move = ROCK;
		} else if (randomNum == 2) {
			move = PAPER;
		} else {
			move = SCISSORS;
		}

		return move;
	}
}
