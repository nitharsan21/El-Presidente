package Technic.Builder;

import Luncher.MainApp;
import Ressources.GlobleVariables.Difficulty;
import Ressources.Island;
import Ressources.President;
import Technic.Interface.Initialize;
import Technic.Tools.DisplayStyle;
import Technic.Tools.InputValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitializeDifficulty implements Initialize {

    /**
     * Setting up the Difficlty level for the game
     */
    public void initialize() {
        int action ;
        List<Difficulty> listdifficultys;
        do{
            System.out.println("\nxxxxxxxxxxxxxxxxx				SELECTION D'UNE NIVEAU DIFFICULTE					xxxxxxxxxxxxxxxxxxxxxx\n");
            listdifficultys = new ArrayList<>(Arrays.asList(Difficulty.values()));
            for(int i = 0; i<listdifficultys.size();i++){
                System.out.println( i+1 +" - " + listdifficultys.get(i));
            }
            System.out.print("\nAction : ");
            try{
                action = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                if(action < 0 || action > listdifficultys.size()){
                    System.out.println(DisplayStyle.ANSI_RED + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ACTION INCONNUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + DisplayStyle.ANSI_RESET);
                    action = 0;
                }
            }catch (Exception ex){
                action = 0;
            }
        }while(action == 0);
//        System.out.println(action);
        MainApp.island.setDifficulty(listdifficultys.get(action-1));

    }
}
