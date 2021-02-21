package Technic.Decision;

import Luncher.MainApp;
import Ressources.Faction;
import Ressources.GlobleVariables.FactionName;
import Technic.Tools.DisplayStyle;
import Technic.Tools.FactionTools;
import Technic.Tools.InputValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FoodMarket {
    /**
     * buying food from the market
     */
    public static void buyFood(){
        System.out.println("\n xxxxxxxxxxxxxxxxxxxx       Le Marché alimentaire       xxxxxxxxxxxxxxxxxxxxx");
        int nbfood = InputValue.getIntegerFor("nombre d'unités alimentaires nécessaires : ");
        double moneyNeeded = nbfood * 8;
        if(confirmationOfFood(moneyNeeded, nbfood)){
            if(moneyNeeded <= MainApp.island.getTreasury().getFundsTotal()) {
                MainApp.island.getTreasury().minusMoneyToTressury(moneyNeeded);
                MainApp.island.addfood(nbfood);
                System.out.println(DisplayStyle.ANSI_GREEN+" Le Marché alimentaire : OK"+DisplayStyle.ANSI_RESET);
            }else {
            System.out.println(DisplayStyle.ANSI_RED + "        -*-     PAS ASSEZ D'ARGENT DANS LE TRÉSOR   -*-     " + DisplayStyle.ANSI_RESET);
            }
        }

    }


    /**
     * get confirmation for the bribe
     */
    public static boolean confirmationOfFood(double money, int nbfood){
        String confirmation;
        do {
            confirmation = InputValue.getStringFor("\n Confirmation : " + money +"€ pour " + nbfood + " unite de nourriture (Oui/ Non ): ");
            if(!(confirmation.equalsIgnoreCase("oui") || confirmation.equalsIgnoreCase("non"))){
                System.out.println(DisplayStyle.ANSI_RED + " !!! Nous avons besoin de confirmation. voulez-vous dire << oui ou non >> pour la nourriture. !!!" + DisplayStyle.ANSI_RESET);
            }
        }while(!(confirmation.equalsIgnoreCase("oui") || confirmation.equalsIgnoreCase("non")));
        return confirmation.equalsIgnoreCase("oui");
    }
}
