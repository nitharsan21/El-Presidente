package Technic.Decision;

import Luncher.MainApp;
import Ressources.Faction;
import Ressources.GlobleVariables.FactionName;
import Technic.Tools.DisplayStyle;
import Technic.Tools.FactionTools;

import java.util.List;
import java.util.Random;

public class Balance {
    /**
     * calcul the balance after an year of events.
     */
    public static void calculBalance(){
        int pouplationTotal = MainApp.island.getCitizenTotal();
        int foodTotal = MainApp.island.getFood();
        if( pouplationTotal*4 <= foodTotal){
            partisansBirth();
        }else{
            int nbdeaths = pouplationTotal - (foodTotal/4);
            partisansDeath(nbdeaths);
        }

    }

    /**
     * algorithm for the birth rate of new supporters
     */
    public static void partisansBirth(){
        List<FactionName> allFactions = FactionTools.getListOfAllFactions();
        Random rand = new Random();
        int birthrate = rand.nextInt(10)+1;
        int globalpopulation = MainApp.island.getCitizenTotal();
        double pivot = birthrate/100.0;
        int nbbirth = (int) (globalpopulation * pivot);
        for(int i = 0;i<nbbirth;i++){
            FactionName faction = allFactions.get(rand.nextInt(allFactions.size()));
            MainApp.island.getFactionFromListWithName(faction).addPartisans(1);
        }
        System.out.println(DisplayStyle.ANSI_GREEN +" "+ nbbirth + " natalité sur l'île" +DisplayStyle.ANSI_RESET );

    }



    /**
     * algorithme for the death rate of supporters
     */
    public static void partisansDeath(int nbdeaths){
        List<FactionName> allFactions = FactionTools.getListOfAllFactions();
        Random rand = new Random();
        for(int i = 0;i<nbdeaths;i++){
            FactionName faction = allFactions.get(rand.nextInt(allFactions.size()));
            MainApp.island.getFactionFromListWithName(faction).minusSatisfaction(2);
            MainApp.island.getFactionFromListWithName(faction).minusPartisans(1);
        }
        System.out.println(DisplayStyle.ANSI_RED +" "+ nbdeaths + " partisans sont élimier  sur l'île" +DisplayStyle.ANSI_RESET );
    }
}
