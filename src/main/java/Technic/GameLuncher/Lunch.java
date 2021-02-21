package Technic.GameLuncher;

import Luncher.MainApp;
import Ressources.Faction;
import Technic.Decision.Balance;
import Technic.Decision.Bribe;
import Technic.Decision.FoodMarket;
import Technic.Tools.*;

public class Lunch {

    /**
     * lunch the first 4 event until the satifaction in down
     */
    public static void gameLuncher(){
        MainApp.island.increaseYear();
        System.out.println("Bonjour M.Presidente :" + MainApp.island.getElpresidente().getFirstName() + ", l'année présidentielle  : " + MainApp.island.getYearsTotal());
        DisplayInformation.displayInformationBeforeTheStart();
        do{
            MainApp.island.incrementNbTour();
            System.out.println("\n\nxxxxxxxxxxxxxxxxx			Event : "+ MainApp.island.getNbtour()+", Saison : "+MainApp.island.getSeason() +"				xxxxxxxxxxxxxxxxxxxxxx");
            EventLuncher.lunchRandomEvent();
            //change season after the event
            MainApp.island.nextSeason();
        }while(MainApp.island.getNbtour() % 4 != 0);

        endOfTheYearFace();

    }

    /**
     * decision making for the end of the year
     */
    public static void endOfTheYearFace(){
        CalculRevenue.calculRevenueOfYear();
        DisplayInformation.displayInformationBeforeTheStart();
        String desisions = " Pot de vin, Le Marché alimentaire, afficher les informations, Bilan de fin d'annéé ";
        System.out.println(DisplayStyle.ANSI_PURPLE + "\n\nxxxxxxxxxxxxxxxxxxxxxxxx        DÉCISION FIN DE L'ANNÉE         xxxxxxxxxxxxxxxxxxxxxxx" + DisplayStyle.ANSI_RESET);
        try {
            do {
                int action = InputActionString.displayAndGetActionsWithString(desisions);
                switch (action) {
                    case 1 -> Bribe.giveBribe();
                    case 2 -> FoodMarket.buyFood();
                    case 3 -> DisplayInformation.displayInformationBeforeTheStart();
                    case 4 -> Balance.calculBalance();
                    default -> System.out.println(DisplayStyle.ANSI_RED + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ACTION INCONNUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + DisplayStyle.ANSI_RESET);
                }
                if (action == 4){
                    break;
                }
            } while (true);

            if(MainApp.island.getSatisfactionGlobal() < DifficultyValues.getGlobalSatisfactionForDifficulty()){
                System.out.println(DisplayStyle.ANSI_RED + "\n\n\n                     -*-   GAME OVER    -*-" + DisplayStyle.ANSI_RESET);
                System.out.println(DisplayStyle.ANSI_BLUE + "\n Un coup d'État est tombé parce que votre satisfaction globale est tombée en dessous de la satisfaction minimale."+ DisplayStyle.ANSI_RESET);
                System.out.println(DisplayStyle.ANSI_BLUE + "\n Votre score est "+ (MainApp.island.getNbtour() * MainApp.island.getYearsTotal()) +" "+ DisplayStyle.ANSI_RESET);
            }else {
                gameLuncher();
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }


}
