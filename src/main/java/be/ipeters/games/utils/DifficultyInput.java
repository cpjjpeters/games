package be.ipeters.games.utils;

public class DifficultyInput {
	private int diffinput;
	public int DifficultyInput() {
		InputRequest ir = new InputRequest();
		diffinput = ir.giveInput("how difficult? (enter a digit)");
		return diffinput;
	}
	

}
