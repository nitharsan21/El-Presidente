package Ressources;

import java.util.HashMap;

public class Choice {
    private String choice;
    private HashMap<String,Double> result ;

    public Choice(String choice, HashMap<String, Double> result) {
        this.choice = choice;
        this.result = result;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public HashMap<String, Double> getResult() {
        return result;
    }

    public void setResult(HashMap<String, Double> result) {
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
