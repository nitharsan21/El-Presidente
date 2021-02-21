package Ressources;

import Ressources.GlobleVariables.FactionName;

import java.util.HashMap;

public class Choice {
    private String choice;
    private HashMap<FactionName, Double> result ;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;

    public Choice(String choice, HashMap<FactionName, Double> result) {
        this.choice = choice;
        this.result = result;
    }

    public Choice(){
        this.result = new HashMap<>();
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

    public Agriculture getAgriculture() {
        return agriculture;
    }

    public void setAgriculture(Agriculture agriculture) {
        this.agriculture = agriculture;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public void setTreasury(Treasury treasury) {
        this.treasury = treasury;
    }

    public void setResource(String nameResource, Double satifaction){
        switch (nameResource) {
            case "AGRICULTURE":
                this.agriculture = new Agriculture(satifaction.doubleValue());
                break;
            case "INDUSTRY":
                this.industry = new Industry(satifaction.doubleValue());
                break;
            case "TREASURY":
                this.treasury = new Treasury(satifaction.doubleValue());
                break;

        }
    }


    @Override
    public String toString() {
        return "Choice{" +
                "choice='" + choice + '\'' +
                ", result=" + result +
                ", agriculture=" + agriculture +
                ", industry=" + industry +
                ", treasury=" + treasury +
                '}';
    }
}
