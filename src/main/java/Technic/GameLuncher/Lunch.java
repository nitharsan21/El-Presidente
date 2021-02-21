package Technic.GameLuncher;

import Luncher.MainApp;
import Technic.Tools.DisplayInformation;

public class Lunch {
    public static void gameLuncher(){
        System.out.println("\n\nxxxxxxxxxxxxxxxxx				START GAME					xxxxxxxxxxxxxxxxxxxxxx");
        MainApp.island.increaseYear();
        DisplayInformation.displayInformationBeforeTheStart();
        do{
            MainApp.island.incrementNbTour();
            System.out.println("\n\nxxxxxxxxxxxxxxxxx			Event : "+ MainApp.island.getNbtour()+" Saison : "+MainApp.island.getSeason() +"				xxxxxxxxxxxxxxxxxxxxxx");
            EventLuncher.LunchRandomEvent();

            //change season after the event
            MainApp.island.nextSeason();
         }while(MainApp.island.getNbtour() % 4 != 0);
    }
}
