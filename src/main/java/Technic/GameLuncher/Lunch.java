package Technic.GameLuncher;

import Luncher.MainApp;
import Ressources.Faction;
import Technic.Decision.Bribe;
import Technic.Tools.CalculRevenue;
import Technic.Tools.DisplayInformation;
import Technic.Tools.DisplayStyle;
import Technic.Tools.InputActionString;

public class Lunch {

    /**
     * lunch the first 4 event until the satifaction in down
     */
    public static void gameLuncher(){
        System.out.println("Bonjour M.Presidente :" + MainApp.island.getElpresidente().getFirstName() + ", l'année présidentielle  :" + MainApp.island.getYearsTotal());
        System.out.println("Saison : " + MainApp.island.getSeason());
        MainApp.island.increaseYear();
        DisplayInformation.displayInformationBeforeTheStart();
        do{
            MainApp.island.incrementNbTour();
            System.out.println("\n\nxxxxxxxxxxxxxxxxx			Event : "+ MainApp.island.getNbtour()+" Saison : "+MainApp.island.getSeason() +"				xxxxxxxxxxxxxxxxxxxxxx");
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
        String desisions = " Pot de vin, Le Marché alimentaire, afficher les informations ";
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx        DÉCISION FIN DE L'ANNÉE         xxxxxxxxxxxxxxxxxxxxxxx");
        try {
            do {
                int action = InputActionString.displayAndGetActionsWithString(desisions);
                switch (action) {
                    case 1:
                        Bribe.giveBribe();
                        break;
                    case 2:
                        break;
                    case 3:
                        DisplayInformation.displayInformationBeforeTheStart();
                        break;
                    default:
                        System.out.println(DisplayStyle.ANSI_RED + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ACTION INCONNUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + DisplayStyle.ANSI_RESET);
                        break;
                }
            } while (true);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }


}
