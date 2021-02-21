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
        if(satisfaction >= 0) {
            if (satisfaction > 100) {
                this.satisfaction = 100;
            } else {
                this.satisfaction = satisfaction;
            }
        }else{
            this.satisfaction = 0;
        }
    }

    public int getNbrPartisans() {
        return nbrPartisans;
    }

    public void setNbrPartisans(int nbrPartisans) {
        this.nbrPartisans = nbrPartisans;
    }


    public void minusSatisfaction(double satisfaction){
        setSatisfaction(this.getSatisfaction() - satisfaction);
    }

    public void addSatisfaction(double satisfaction){
        setSatisfaction(this.getSatisfaction() + satisfaction);
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
