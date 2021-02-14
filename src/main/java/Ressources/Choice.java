package Ressources;

import Ressources.GlobleVariables.FactionName;

import java.util.HashMap;

public class Choice {
    private String choice;
    private HashMap<FactionName,Double> result ;

    public Choice(String choice, HashMap<FactionName, Double> result) {
        this.choice = choice;
        this.result = result;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public HashMap<FactionName, Double> getResult() {
        return result;
    }

    public void setResult(HashMap<FactionName, Double> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choice='" + choice + '\'' +
                ", result=" + result +
                '}';
    }
}
