package Ressources;

import Ressources.GlobleVariables.FactionName;

public class Faction {
    private FactionName title;
    private double satisfaction;
    private int nbrPartisans;

    public Faction(FactionName title, double satisfaction, int nbrPartisans) {
        this.title = title;
        this.satisfaction = satisfaction;
        this.nbrPartisans = nbrPartisans;
    }
    public Faction(FactionName title) {
        this.title = title;
    }


    public FactionName getTitle() {
        return title;
    }

    public void setTitle(FactionName title) {
        this.title = title;
    }

    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getNbrPartisans() {
        return nbrPartisans;
    }

    public void setNbrPartisans(int nbrPartisans) {
        this.nbrPartisans = nbrPartisans;
    }


    @Override
    public String toString() {
        return "Faction{" +
                "title='" + title + '\'' +
                ", satisfaction=" + satisfaction +
                ", nbrPartisans=" + nbrPartisans +
                '}';
    }
}
