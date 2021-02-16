package Technic.Builder;
import Ressources.Island;

public class BuildIsland {

    /** building all the nessairy variables for the game*/
    public static void build(){
        new InitializeNewIsland().initialize();
        new InitializePresident().initialize();
        new InitializeDifficulty().initialize();
    }
}
