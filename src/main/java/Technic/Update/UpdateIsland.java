package Technic.Update;

import Luncher.MainApp;
import Ressources.Agriculture;
import Ressources.Choice;
import Ressources.Faction;
import Ressources.Industry;
import Technic.Interface.Update;
import Technic.Tools.DifficultyValues;

public class UpdateIsland implements Update {

    @Override
    public void updateIsland(Choice choice) {
        if(choice != null){
            int nbPartisanstotal = 0;
            for(Faction faction : MainApp.island.getFactions()){
                for(Faction choiceFaction : choice.getResultFaction()){
                    if(faction.getTitle().equals(choiceFaction.getTitle())){
                        faction.setSatisfaction(faction.getSatisfaction() + choiceFaction.getSatisfaction());
                        double pt = (100 + (choiceFaction.getNbrPartisans()))/100.0;
                        double pttotal = faction.getNbrPartisans() * pt;
                        faction.setNbrPartisans((int) pttotal);
                        nbPartisanstotal += faction.getNbrPartisans();
                    }
                }
            }
            MainApp.island.setCitizenTotal(nbPartisanstotal);
            if(choice.getTreasury().getFundsTotal() != 0){
                double funds = MainApp.island.getTreasury().getFundsTotal();
                MainApp.island.getTreasury().setFundsTotal(funds + choice.getTreasury().getFundsTotal());
            }
            this.setAgricultureAndIndustry(choice.getAgriculture(), choice.getIndustry());

            MainApp.island.calculSatisfactionGlobal();
        }
    }

    /**
     * verifiction and set cumul of Agriculture and industry
     * @param agriculture choice agriculture
     * @param industry choice industry
     */
    public void setAgricultureAndIndustry(Agriculture agriculture, Industry industry){
        double cumulAgricul =  (MainApp.island.getAgriculture().getCumulative() + agriculture.getCumulative());
        double cumulIndus = (MainApp.island.getIndustry().getCumulative() + industry.getCumulative());
        if(cumulAgricul + cumulIndus <= 100){
            MainApp.island.getAgriculture().setCumulative(cumulAgricul);
            MainApp.island.getIndustry().setCumulative(cumulIndus);
        }
        else if(cumulAgricul + MainApp.island.getIndustry().getCumulative() <= 100 ){
            MainApp.island.getAgriculture().setCumulative(cumulAgricul);
            double cumumI = (cumulAgricul + cumulIndus) - 100;
            MainApp.island.getIndustry().setCumulative(MainApp.island.getIndustry().getCumulative() + cumumI);
        }

        else if(cumulIndus + MainApp.island.getAgriculture().getCumulative() <= 100 ){
            MainApp.island.getIndustry().setCumulative(cumulIndus);
            double cumumI = (cumulAgricul + cumulIndus) - 100;
            MainApp.island.getAgriculture().setCumulative(MainApp.island.getAgriculture().getCumulative() + cumumI);
        }
    }

}
