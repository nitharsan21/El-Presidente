package Ressources;

import java.util.List;

public class Island {
    private President elpresidente;
    private List<Faction> Factions;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;
    private int citizenTotal;
    private double satisfactionGlobal;
    private int yearsTotal;


    public Island(President elpresidente, List<Faction> factions, Agriculture agriculture, Industry industry, Treasury treasury, int citizenTotal, double satisfactionGlobal, int yearsTotal) {
        this.elpresidente = elpresidente;
        Factions = factions;
        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;
        this.citizenTotal = citizenTotal;
        this.satisfactionGlobal = satisfactionGlobal;
        this.yearsTotal = yearsTotal;
    }


    public President getElpresidente() {
        return elpresidente;
    }

    public void setElpresidente(President elpresidente) {
        this.elpresidente = elpresidente;
    }

    public List<Faction> getFactions() {
        return Factions;
    }

    public void setFactions(List<Faction> factions) {
        Factions = factions;
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

    public int getCitizenTotal() {
        return citizenTotal;
    }

    public void setCitizenTotal(int citizenTotal) {
        this.citizenTotal = citizenTotal;
    }

    public double getSatisfactionGlobal() {
        return satisfactionGlobal;
    }

    public void setSatisfactionGlobal(double satisfactionGlobal) {
        this.satisfactionGlobal = satisfactionGlobal;
    }

    public int getYearsTotal() {
        return yearsTotal;
    }

    public void setYearsTotal(int yearsTotal) {
        this.yearsTotal = yearsTotal;
    }

    @Override
    public String toString() {
        return "Island{" +
                "elpresidente=" + elpresidente +
                ", Factions=" + Factions +
                ", agriculture=" + agriculture +
                ", industry=" + industry +
                ", treasury=" + treasury +
                ", citizenTotal=" + citizenTotal +
                ", satisfactionGlobal=" + satisfactionGlobal +
                ", yearsTotal=" + yearsTotal +
                '}';
    }
}
