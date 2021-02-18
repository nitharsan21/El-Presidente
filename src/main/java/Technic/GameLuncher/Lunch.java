package Technic.GameLuncher;

import Luncher.MainApp;
import Technic.Tools.DisplayInformation;

public class Lunch {
    public static void gameLuncher(){

        MainApp.island.increaseYear();
        DisplayInformation.displayInformationBeforeTheStart();
        do{
            System.out.println();

        }while(MainApp.island.getNbtour() % 4 == 0);
    }
}
