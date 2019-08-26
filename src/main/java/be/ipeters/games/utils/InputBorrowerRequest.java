package be.ipeters.games.utils;
import java.util.Scanner;

public class InputBorrowerRequest {
	Scanner input = new Scanner(System.in);

	public String giveInput(String message) {
		System.out.println("\nPlease enter " + message);
		String inputnext = input.next();	
//		 System.out.println(" you gave " + inputnext + " as input");
		return inputnext;
	}
}
