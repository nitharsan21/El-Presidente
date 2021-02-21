package Technic.Builder;
import Luncher.MainApp;
import Ressources.Island;

import java.io.File;

public class BuildIsland {

    /**
     *  building all the necessary variables for the game
     */
    public static void build(){
        new InitializeNewIsland().initialize();
        new InitializePresident().initialize();
        new InitializeDifficulty().initialize();

        File pathevent = new File(MainApp.PATH_EVENT);
        EventBuilder.buildEvent(pathevent);


    }
}
