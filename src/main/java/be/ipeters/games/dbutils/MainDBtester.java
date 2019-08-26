package be.ipeters.games.dbutils;
import be.ipeters.games.datamodel.BorrowListObject;
import be.ipeters.games.datamodel.Borrower;
import be.ipeters.games.utils.ListSorter;

import java.util.ArrayList;
import java.util.List;

public class MainDBtester {

	public static void main(String[] args) {
		GamesDAO gamesdao = new GamesDAO();
//		System.out.println(gamesdao.findGameById(5));
//		System.out.println(gamesdao.findCategoryById(1));
//		System.out.println(gamesdao.findBorrowerById(1));
//		System.out.println(gamesdao.findAllDetailsGameById(5).toString());
//		System.out.println(gamesdao.selectDifficultyGames(3));
//		System.out.println(gamesdao.findAllBorrowedGames());
		System.out.println("--------------------------");
		
		ListSorter ls = new ListSorter();
		ArrayList<BorrowListObject> unsortedlist,sortedongame, sortedonborrower;
		unsortedlist=gamesdao.findAllBorrowedGames();
		sortedongame = gamesdao.findAllBorrowedGamesSortedOnGame();
		System.out.println();
		//sortedonborrower = ls.sortOnBorrower(unsortedlist);
//		sortedonborrower = gamesdao.findAllBorrowedGamesSortedOnBorrower();
//		for (BorrowListObject blo:sortedongame) {
//			System.out.println(blo);
//		}
//		System.out.println("------ sorted on game --------------------");
//		for (BorrowListObject blo:sortedonborrower) {
//			System.out.println(blo);
//		}
//		System.out.println("------ sorted on borrower --------------------");
//		
//		for (BorrowListObject blo:unsortedlist) {
//			System.out.println(blo);
//		}
//		System.out.println("------ unsorted --------------------");
		Borrower bow =gamesdao.findBorrowerByName("Kevin");
		unsortedlist= gamesdao.findAllBorrowedGamesPerBorrower(bow.getId());
		for(BorrowListObject blo:unsortedlist) {
			System.out.println(blo);
		}
		
	}

}
