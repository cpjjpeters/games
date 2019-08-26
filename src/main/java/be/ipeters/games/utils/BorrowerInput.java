package be.ipeters.games.utils;

public class BorrowerInput {
private String input;
	
	public String Start() {
	InputBorrowerRequest ibr = new InputBorrowerRequest();
	input=ibr.giveInput("borrowers name or part of it");
	//System.out.println("You entered: "+input);
	return input;
	}

}
