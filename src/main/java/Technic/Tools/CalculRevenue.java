package Technic.Tools;

import Luncher.MainApp;

public class CalculRevenue {
    /**
     * calcul the revenue of the year
     */
    public static void calculRevenueOfYear(){
        int food = (int) (40.0 * MainApp.island.getAgriculture().getCumulative());
        MainApp.island.setFood(food);
        double money = (10.0 * MainApp.island.getIndustry().getCumulative());
        MainApp.island.getTreasury().addMoneyToTressury(money);
        MainApp.island.calculSatisfactionGlobal();
    }
}
