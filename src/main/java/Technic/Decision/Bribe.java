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

public class Bribe {
    /**
     * give bribe to get more satifaction
     */
    public static void giveBribe(){
        FactionName faction = printfactiontoChoice();
        Faction fact = MainApp.island.getFactionFromListWithName(faction);
        double moneyneeded = 15 * fact.getNbrPartisans();
        if(confirmationOfBribe(moneyneeded)){
            if(moneyneeded <= MainApp.island.getTreasury().getFundsTotal()){
                double minusSatifaction = moneyneeded/10.0;
                MainApp.island.getTreasury().minusMoneyToTressury(moneyneeded);
                MainApp.island.getFactionFromListWithName(FactionName.LOYALISTS).minusSatisfaction(minusSatifaction);
                fact.addSatisfaction(10);
                MainApp.island.calculSatisfactionGlobal();
                System.out.println(DisplayStyle.ANSI_GREEN + " Pot de vin : OK" + DisplayStyle.ANSI_RESET);
            }else {
                System.out.println(DisplayStyle.ANSI_RED + "        -*-     PAS ASSEZ D'ARGENT DANS LE TRÉSOR   -*-     " + DisplayStyle.ANSI_RESET);
            }
        }

    }

    /**
     * print all faction to choise a faction
     */
    public static FactionName printfactiontoChoice(){
        List<FactionName> allFactions = FactionTools.getListOfAllFactions();
        int action ;

        do{
            System.out.println("\n\nxxxxxxxxxxxxxxxxx		CHOISIR UNE FACTION POUR FAIRE UN POT DE VIN 		xxxxxxxxxxxxxx\n");
            for(int i = 0; i<allFactions.size();i++){
                System.out.println( i+1 +" - " +allFactions.get(i));
            }
            System.out.print("\nAction : ");
            try{
                action = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                if(action < 0 || action >allFactions.size()){
                    System.out.println(DisplayStyle.ANSI_RED+" !!! - Action INCONNU - Entrez un nombre - !!! "+ DisplayStyle.ANSI_RESET);
                    action = 0;
                }
            }catch (Exception ex){
                action = 0;
            }
        }while(action == 0);
        return allFactions.get(action-1);
    }


    /**
     * get confirmation for the bribe
     */
    public static boolean confirmationOfBribe(double bribe){
        String confirmation;
        do {
             confirmation = InputValue.getStringFor("\n Confirmation " + bribe +"€ de pot de vin(Oui/ Non ): ");
            if(!(confirmation.equalsIgnoreCase("oui") || confirmation.equalsIgnoreCase("non"))){
                System.out.println(DisplayStyle.ANSI_RED + " !!! Nous avons besoin de confirmation. voulez-vous dire << oui ou non >> pour la pot de vin. !!!" + DisplayStyle.ANSI_RESET);
            }
        }while(!(confirmation.equalsIgnoreCase("oui") || confirmation.equalsIgnoreCase("non")));
        return confirmation.equalsIgnoreCase("oui");
    }
}
