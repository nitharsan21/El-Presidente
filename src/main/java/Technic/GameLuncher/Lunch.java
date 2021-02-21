package Technic.GameLuncher;

import Luncher.MainApp;
import Technic.Tools.DisplayInformation;

public class Lunch {
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

    }

    public static void endOfTheYearFace(){
        DisplayInformation.displayInformationBeforeTheStart();

    }
}
