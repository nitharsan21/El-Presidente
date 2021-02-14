package Ressources;

public class Faction {
    private String title;
    private double satisfaction;
    private int nbrPartisans;

    public Faction(String title, double satisfaction, int nbrPartisans) {
        this.title = title;
        this.satisfaction = satisfaction;
        this.nbrPartisans = nbrPartisans;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
