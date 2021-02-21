package Technic.Tools;

import Luncher.MainApp;
import Ressources.GlobleVariables.Difficulty;

public class DifficultyValues {

    /**
     * get a value that correspond a Difficulty level
     * @param value double value
     * @return value that correspond a Difficulty level
     */
    public static double getValueWithDifficulty(double value){
        if(MainApp.island.getDifficulty().equals(Difficulty.EASY)){
            if(value > 0) {
                value = value * 2.0;
            }else if(value < 0){
                value = value / 2.0;
            }
        }else if(MainApp.island.getDifficulty().equals(Difficulty.HARD)){
            if(value > 0) {
                value = value / 2.0;
            }else if(value < 0){
                value = value * 2.0;
            }
        }
        return value;
    }

    public static double getGlobalSatisfactionForDifficulty(){
        switch (MainApp.island.getDifficulty()){
            case EASY:
                return 10.0;
            case NORMAL:
                return 30.0;
            case HARD:
                return 50.0;
            default:
                return 25.0;

        }
    }
}
