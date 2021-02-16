package Luncher;

import Ressources.*;
import Technic.Builder.BuildIsland;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static Island island;
    public static List<Event> events = new ArrayList<>();


    /**
     * @param args
     * it start to launch the game by creating the nessary element
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuildIsland.build();
       // System.out.println(MainApp.island.toString());
        System.out.println(MainApp.island.getDifficulty());
    }
}
