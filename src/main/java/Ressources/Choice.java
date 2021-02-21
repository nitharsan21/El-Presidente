package Ressources;

import Ressources.GlobleVariables.FactionName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Choice {
    private String choice;
    private List<Faction> resultFaction ;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;


    public Choice(){
        this.resultFaction = new ArrayList<>();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<Faction> getResult() {
        return resultFaction;
    }

    public void setResult(List<Faction> result) {
        this.resultFaction = result;
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
            case "AGRICULTURE" -> this.agriculture = new Agriculture(satifaction);
            case "INDUSTRY" -> this.industry = new Industry(satifaction);
            case "TREASURY" -> this.treasury = new Treasury(satifaction);
        }
    }


    @Override
    public String toString() {
        return "Choice{" +
                "choice='" + choice + '\'' +
                ", result=" + resultFaction +
                ", agriculture=" + agriculture +
                ", industry=" + industry +
                ", treasury=" + treasury +
                '}';
    }
}
