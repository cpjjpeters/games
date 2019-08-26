package be.ipeters.games.utils;

public class GameInput {
	private String input;
	
	public String Start() {
	InputGameRequest igr = new InputGameRequest();
	input=igr.giveInput("a game name or part of the game name.");
	//System.out.println("You entered: "+input);
	return input;
	}
}
