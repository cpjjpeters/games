package be.ipeters.games.main;

import be.ipeters.games.utils.MenuController;

public class GamesRunner {
    public static void main(String[] args) {
        MenuController mc = new MenuController();
        Gui gui = new Gui();
        gui.start();
    }
}
