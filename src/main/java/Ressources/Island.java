package Ressources;

import Luncher.MainApp;
import Ressources.GlobleVariables.Difficulty;
import Ressources.GlobleVariables.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Island {
    private President elpresidente;
    private List<Faction> Factions;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;
    private Season season;
    private Difficulty difficulty;
    private int nbtour;
    private int citizenTotal;
    private double satisfactionGlobal;
    private int yearsTotal;


    public Island(President elpresidente, List<Faction> factions, Agriculture agriculture,
                  Industry industry, Treasury treasury, Season season, int nbtour,
                  int citizenTotal, double satisfactionGlobal, int yearsTotal) {
        this.elpresidente = elpresidente;
        Factions = factions;
        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;
        this.season = season;
        this.nbtour = nbtour;
        this.citizenTotal = citizenTotal;
        this.satisfactionGlobal = satisfactionGlobal;
        this.yearsTotal = yearsTotal;
    }

    /**create an empty class island  for the initialization purpose*/
    public Island(){
        this.Factions = new ArrayList<>();
        this.nbtour = 0;
        this.yearsTotal = 0;

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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void nextSeason(){
        List<Season> listseason = Arrays.asList(Season.values().clone());
        int index = listseason.indexOf(this.season);
        if(!listseason.get(index + 1 ).equals(Season.ALL)){
            this.season = listseason.get(index + 1);
        }else {
            this.season = Season.SPRING;
        }

    }

    public void addFaction(Faction faction){
        if(faction != null){
            this.Factions.add(faction);
        }
    }

    public double calculSatisfactionGlobal() {
        double totalsupporters = 0;
        double calculsatisfaction = 0;
        for(Faction faction : this.getFactions()){
            totalsupporters += faction.getNbrPartisans();
            calculsatisfaction += faction.getSatisfaction() * faction.getNbrPartisans();
        }
        return calculsatisfaction/totalsupporters;
    }

    public int getcitizenTotalFromFaction(){
        int totalcitizen = 0;
        for(Faction faction : this.getFactions()){
            totalcitizen += faction.getNbrPartisans();
        }
        return totalcitizen;
    }

    public int getNbtour() {
        return nbtour;
    }

    public void incrementNbTour(){
        this.nbtour ++;
    }


    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void increaseYear(){
        this.yearsTotal ++;
    }

    @Override
    public String toString() {
        return "Island{" +
                "elpresidente=" + elpresidente + "\n"+
                ", Factions=" + Factions + "\n"+
                ", agriculture=" + agriculture + "\n"+
                ", industry=" + industry + "\n"+
                ", treasury=" + treasury + "\n"+
                ", season=" + season + "\n"+
                ", difficulty=" + difficulty + "\n"+
                ", nbtour=" + nbtour + "\n"+
                ", citizenTotal=" + citizenTotal + "\n"+
                ", satisfactionGlobal=" + satisfactionGlobal + "\n"+
                ", yearsTotal=" + yearsTotal + "\n"+
                '}';
    }

    /**
     * all information about the isaland
     */
    public void printSatisfaction(){
        System.out.println("Bonjour M.Presidente :" + this.getElpresidente().getFirstName() + ", l'année présidentielle  :" + this.yearsTotal);
        System.out.println("Saison : " + this.season);
        System.out.println("\n_________________FACTIONS :_____________________");
        for (Faction faction : this.getFactions()){
            System.out.println(" Faction : " + faction.getTitle() + ", satisfaction :" + faction.getSatisfaction() + "%, nbpartisans : " + faction.getNbrPartisans());
        }
        System.out.println("\n_________________RESSOURCES :_____________________");
        System.out.println(" Ressource :  Agriculture,      cumul :" + agriculture.getCumulative() + "% ");
        System.out.println(" Ressource :  Industry,         cumul :" + industry.getCumulative() + "% ");
        System.out.println(" Ressource :  Treasury,         cumul :" + treasury.getFundsTotal() + "€ ");


        System.out.println("\n\nSatisfaction Global : " + this.satisfactionGlobal + "%");


    }
}
