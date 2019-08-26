package be.ipeters.games.utils;
import be.ipeters.games.datamodel.BorrowListObject;

import java.util.stream.*;


import java.util.*;

public class ListSorter {
	
	public ArrayList<BorrowListObject> sortOnBorrower(ArrayList<BorrowListObject> inputborrowobjectlist){
		ArrayList<BorrowListObject> difgames ;
		difgames=inputborrowobjectlist;
		difgames.sort(Comparator.comparing(BorrowListObject::getBorrower));
		return difgames;
	}
// ----------------------------------------------------------------------------------------------------------------------------------	
	public ArrayList<BorrowListObject> sortOnGame(ArrayList<BorrowListObject> inputborrowobjectlist){
		inputborrowobjectlist.sort(Comparator.comparing(BorrowListObject::getGame));
		return inputborrowobjectlist;
	}
	// ----------------------------------------------------------------------------------------------------------------------------------	

}

//----------------------------------------------------------------------------------------------------------------------------------	

/*
*ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>();
		CleanConsole();
		System.out.println("These are the borrowed games  ");
		blos = gamesdao.findAllBorrowedGames();
		blos.sort((Comparator.comparing(BorrowListObject::getBorrower)));
		for (BorrowListObject blo : blos) {
			System.out.printf("game=%33s borrowed by %20s from %s to %s.\n",blo.getGame(), blo.getBorrower(),blo.getBorrowDate(), ((blo.getReturnDate()==null) ? "...":blo.getReturnDate()));
		}
*/
