package Luncher;

import Ressources.*;
import Technic.Builder.BuildIsland;
import Technic.GameLuncher.Lunch;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    /**
     * path of event data
     */
    public static final String PATH_EVENT = "src/main/java/Data/events.json";

    /**
     * varables singleton
     */
    public static Island island;
    public static List<Event> events = new ArrayList<>();


    /**
     * @param args
     * it start to launch the game by creating the nessary element
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuildIsland.build();

        System.out.println("\n\nxxxxxxxxxxxxxxxxx				START GAME					xxxxxxxxxxxxxxxxxxxxxx");
        Lunch.gameLuncher();
//        System.out.println(MainApp.island.toString());
//        System.out.println(MainApp.island.getDifficulty());
    }
}
