package Technic.Builder;
import Luncher.MainApp;
import Ressources.*;
import Ressources.GlobleVariables.FactionName;
import Ressources.GlobleVariables.Season;
import Technic.Interface.Initialize;
import Technic.Tools.FactionTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitializeNewIsland implements Initialize{
    /**
     * initialization of the new island with all the parameters
     */
    public void initialize(){
        try {
            MainApp.island = new Island();

           //Initializing factions
           List<FactionName> allFactions = FactionTools.getListOfAllFactions();

           for(FactionName nameFaction : allFactions){
               Faction newFaction = new Faction(nameFaction);
               if(nameFaction.equals(FactionName.LOYALISTS)){
                   newFaction.setSatisfaction(100);
               }else{
                   newFaction.setSatisfaction(50);
               }
               newFaction.setNbrPartisans(15);

               MainApp.island.addFaction(newFaction);
           }
            MainApp.island.setCitizenTotal(MainApp.island.getcitizenTotalFromFaction());

            MainApp.island.setAgriculture(new Agriculture(15));
            MainApp.island.setIndustry(new Industry(15));
            MainApp.island.setTreasury(new Treasury(200));

            MainApp.island.setSatisfactionGlobal(MainApp.island.calculSatisfactionGlobal());
            MainApp.island.setSeason(Season.SPRING);
//           System.out.println(MainApp.island.toString());

       }catch (Exception ex){
           System.out.println(ex.getMessage());
       }


    }

}
