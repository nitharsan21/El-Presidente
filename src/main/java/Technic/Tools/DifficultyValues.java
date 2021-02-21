package Technic.Tools;

import Luncher.MainApp;
import Ressources.GlobleVariables.Difficulty;

public class DifficultyValues {
    public static double getValueWithDiffculty(double value){
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
}
