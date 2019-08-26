package be.ipeters.games.utils;
 
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MenuController {
	
	public Map fillHashMain() {
		Map<String, String> menuHash = new TreeMap<>();
		menuHash.put(" 1", "Show the first game category");
		menuHash.put(" 2", "Show the fifth game");
		menuHash.put(" 3", "Show the first borrower");
		menuHash.put("99", "Quit program");
		menuHash.put(" 4", "Show a game of your choice");
		menuHash.put(" 5", "Show all games");
		menuHash.put(" 6", "Show a list of games and choose a game ");
		menuHash.put(" 7", "Show borrowed games");
		menuHash.put(" 8", "Advanced search: difficulty");
		//menuHash.put(" 9", "Complex search:borrowers");
		//menuHash.put("10", "Third way of searching");
		menuHash.put("11", "Administration-side borrowed games");
		menuHash.put("38", "For testing purposes only");
		return menuHash;
	}
//	public Map fillHashMain() {
//		Map<Integer, String> menuHash = new TreeMap<>();
//		menuHash.put(1, "Show the first game category");
//		menuHash.put(2, "Show the fifth game");
//		menuHash.put(3, "Show the first borrower");
//		menuHash.put(99, "Quit program");
//		menuHash.put(4, "Show a game of your choice");
//		menuHash.put(5, "Show all games");
//		menuHash.put(6, "Show a list of games and choose a game ");
//		menuHash.put(7, "Show borrowed games");
//		menuHash.put(8, "Advanced search: difficulty");
//		menuHash.put(38, "For testing purposes only");
//		return menuHash;
//	}
	public Map fillDifficultyMap() {
		Map<Integer, String> menuHash = new TreeMap<>();
		menuHash.put(1, "very easy");
		menuHash.put(2, "easy");
		menuHash.put(3, "average");
		menuHash.put(4, "difficult");
		menuHash.put(5, "very difficult");
		return menuHash;
	}
	
	public Map fillHashTwo() {
		Map<Integer, String> menuHash = new TreeMap<>();
		menuHash.put( 1, "Game details");
		menuHash.put(99, "Go to previous menu");
		return menuHash;
	}
	
	public Map fillHashGoBack() {
		Map<Integer, String> menuHash = new TreeMap<>();
		menuHash.put(99, "Go to previous menu");
		return menuHash;
	}
	public Map fillHashSix() {
		Map<Integer, String> menuHash = new TreeMap<>();
		menuHash.put(1, "Game details");
		menuHash.put(99, "Go to previous menu");
		return menuHash;
	}
	public Map fillHashSeven() {
		Map<String, String> menuHash = new TreeMap<>();
		menuHash.put(" 1", "Order on game");
		menuHash.put(" 2", "Order on borrower");		
		menuHash.put(" 3", "Look up a borrower");
		menuHash.put("99", "Go to previous menu");
		return menuHash;
	}
	public Map fillHashThirtyEigth() {
		Map<Integer, String> menuHash = new TreeMap<>();
		menuHash.put( 1, "Go on Game");
		menuHash.put( 2, "More stuff");
		menuHash.put(99, "Go to previous menu");
		return menuHash;
	}
	public void showHash(Map<Integer, String> menuHash) {
		Set set = menuHash.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.printf("%s - ", me.getKey());
			System.out.println(me.getValue());
		}
	}
	
}
