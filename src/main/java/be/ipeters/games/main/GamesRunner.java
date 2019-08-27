package be.ipeters.games.main;

import be.ipeters.games.utils.MenuController;

public class GamesRunner {
    public static void main(String[] args) {
        MenuController mc = new MenuController();
        GUI gui = new GUI();
        gui.start();
    }
}
