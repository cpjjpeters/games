package be.ipeters.games.main;

import be.ipeters.games.datamodel.BorrowListObject;
import be.ipeters.games.datamodel.Borrower;
import be.ipeters.games.datamodel.DifficultGame;
import be.ipeters.games.datamodel.Game;
import be.ipeters.games.dbutils.GamesDAO;
import be.ipeters.games.utils.*;

import java.util.ArrayList;
import java.util.Comparator;

public class MenuView {
    // *********************************************************************
    MenuController mcsub = new MenuController();
    GamesDAO gamesdao = new GamesDAO();

    public void CleanConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void SubCleanConsole() {
        for (int i = 0; i < 05; i++) {
            System.out.println();
        }
    }

    public void MenuItem1() {
        CleanConsole();
        System.out.println("Showing the first game category");
        System.out.println("-------------------------------");
        System.out.println(gamesdao.findCategoryById(1));
        // mcsub.showHash(mcsub.fillHashGoBack());
        System.out.println("   ........................................................     ");
    }

    public void MenuItem2() {
        CleanConsole();
        System.out.println("Showing the 5th item");
        System.out.println("--------------------");
        System.out.println(gamesdao.findGameById(5).toSmallString());
        // need submenu to show details
        System.out.println("   ........................................................     ");
        mcsub.showHash(mcsub.fillHashTwo());
        System.out.println("   ........................................................     ");
    }

    public void MenuItem3() {
        CleanConsole();
        System.out.println("Showing the first borrower");
        System.out.println("--------------------------");
        System.out.println(gamesdao.findBorrowerById(1));
        System.out.println("   ........................................................     ");
    }

    public void MenuItem4() {
        CleanConsole();
        System.out.println("Show a game of your choice ");
        System.out.println("---------------------------");
        GameInput gi = new GameInput();
        String lookupGame = gi.Start();
        Game game = gamesdao.lookForAGame(lookupGame);
        if (game == null) {
            System.out.println("No game was found with parameter " + lookupGame);
        } else {
            System.out.println(gamesdao.lookForAGame(lookupGame));
        }
        System.out.println("   ........................................................     ");
    }

    public void MenuItem5() {
        ArrayList<Game> games = new ArrayList<Game>();
        CleanConsole();
        System.out.println("Show all games ");
        games = gamesdao.findAllGames();
        for (Game game : games) {
            System.out.println(game.toStringAllGames());
        }
        System.out.printf("\n\tThere are %d games in this database.\n", games.size());
//		mcsub.showHash(mcsub.fillHashGoBack());
        System.out.println("   ........................................................     ");
    }

    public void MenuItem6() {
        ArrayList<Game> games = new ArrayList<Game>();
        CleanConsole();
        System.out.println("Show a list of games and choose a game  ");
        games = gamesdao.findAllGames();
        for (Game game : games) {
            System.out.println(game.toStringAllGames());
        }
        GameInput gi = new GameInput();
        String lookupGame = gi.Start();
        SubCleanConsole();
        System.out.printf("With %s as input, we found this in our database:\n", lookupGame);
        System.out.println(gamesdao.lookForAGame(lookupGame));
//		mcsub.showHash(mcsub.fillHashGoBack());
        System.out.println("   ........................................................     ");
    }

    public void MenuItem7() {
        ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>();
        CleanConsole();
        System.out.println("These are the borrowed games  ");
        blos = gamesdao.findAllBorrowedGames();
        blos.sort((Comparator.comparing(BorrowListObject::getBorrower)));
        for (BorrowListObject blo : blos) {
            System.out.printf("game=%33s borrowed by %20s from %s to %s.\n", blo.getGame(), blo.getBorrower(),
                    blo.getBorrowDate(), ((blo.getReturnDate() == null) ? "..." : blo.getReturnDate()));
        }
        mcsub.showHash(mcsub.fillHashSeven());
        InputRequest ir = new InputRequest();
        ArrayList<BorrowListObject> unsortedlist,sortedongame, sortedonborrower;
        int choice;
        choice = ir.giveInput("your choice");
        while (choice != 99) {
            switch (choice) {
                case 1:
                    SubCleanConsole();
                    System.out.println("Sorting on games name");
                    sortedongame = gamesdao.findAllBorrowedGamesSortedOnGame();
                    for (BorrowListObject blo:sortedongame) {
                        System.out.println(blo);
                    }
                    System.out.println("------ sorted on game --------------------");
                    SubCleanConsole();
                    //mv.MenuItem1();
                    break;
                case 2:
                    SubCleanConsole();
                    System.out.println("Doing a sort on borrower");
                    sortedonborrower = gamesdao.findAllBorrowedGamesSortedOnBorrower();
                    for (BorrowListObject blo:sortedonborrower) {
                        System.out.println(blo);
                    }
                    System.out.println("------ sorted on borrower --------------------");
                    SubCleanConsole();
                    break;
                case 3:
                    SubCleanConsole();
                    System.out.println("looking up borrower");
                    BorrowerInput bi = new BorrowerInput();
                    String lookupBorrower = bi.Start();
                    Borrower bow =gamesdao.findBorrowerByName(lookupBorrower);
                    unsortedlist= gamesdao.findAllBorrowedGamesPerBorrower(bow.getId());
                    for(BorrowListObject blo:unsortedlist) {
                        System.out.println(blo);
                    }
                    System.out.println("------ by borrower --------------------");
                    SubCleanConsole();
                    break;
                default:
                    SubCleanConsole();
                    System.out.println("this is unexpected, retry please.\n");
                    SubCleanConsole();
            }
            mcsub.showHash(mcsub.fillHashSeven());
            choice = ir.giveInput("your choice");
            // System.out.println("choice= "+choice);
        }
        // to do soon


//		Predicate<BorrowListObject> byBorrower= blo ->blo.getBorrower();
//		blossorted=blos.stream().filter(byBorrower).collect(Collectors.<BorrowListObject> toList());
//		testList.sort(Comparator.comparing(ClassName::getFieldName));
//		System.out.println(gamesdao.lookForAGame(lookupGame));
//		System.out.println("   ........................................................     ");
//		mcsub.showHash(mcsub.fillHashSeven());
        System.out.println("   ........................................................     ");
    }

    public void MenuItem8() {
        ArrayList<DifficultGame> difgames = new ArrayList<DifficultGame>();
        CleanConsole();
        System.out.println("Difficulty ");
        mcsub.showHash(mcsub.fillDifficultyMap());
        DifficultyInput di = new DifficultyInput();
        int level = di.DifficultyInput();
        // maak hier een select van alle games die minstens % moeilijk zijn
        difgames = gamesdao.selectDifficultyGames(level);
        for (DifficultGame dgm : difgames) {
            System.out.println(dgm.toString());
        }
        System.out.println("   ........................................................     ");
    }
    public void MenuItem11() {
        CleanConsole();
        System.out.println("Add a new loan");
        System.out.println("--------------");
    }
    public void MenuItem38() {
        CleanConsole();
        System.out.println("ThirtyEigth ");
        mcsub.showHash(mcsub.fillHashThirtyEigth());
        InputRequest ir = new InputRequest();
        int choice;
        choice = ir.giveInput("your choice");
        while (choice != 99) {
            switch (choice) {
                case 1:
                    SubCleanConsole();
                    System.out.println("blah 1");
                    break;
                case 2:
                    SubCleanConsole();
                    System.out.println("blah 2");
                    break;
                default:
                    SubCleanConsole();
                    System.out.println("this is unexpected, retry please.\n");

            }
            SubCleanConsole();
            mcsub.showHash(mcsub.fillHashThirtyEigth());
            choice = ir.giveInput("your choice");
        }
        System.out.println("   ........................................................     ");
    }

    //*********************************************************************fillHashThirtyEigth
    public void SubMenuAllGames() {
        CleanConsole();
        System.out.println("SubMenuAllGames, ...");
        System.out.println("gamesdao.findAll");
        System.out.println("");
    }

    public void SubMenuGameDetail() {
        CleanConsole();
        System.out.println("SubMenuGameDetail, details of fifth game...");
        System.out.println(gamesdao.findAllDetailsGameById(5).toString());
        System.out.println("   ........................................................     ");
    }
}
//*********************************************************************