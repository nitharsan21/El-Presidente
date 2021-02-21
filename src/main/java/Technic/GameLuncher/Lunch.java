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
            System.out.println("\n\nxxxxxxxxxxxxxxxxx			Event :"+ MainApp.island.getNbtour()+"				xxxxxxxxxxxxxxxxxxxxxx");

            MainApp.island.nextSeason();
         }while(MainApp.island.getNbtour() % 4 != 0);
    }
}
