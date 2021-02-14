package Ressources;

public class Treasury {
    private double fundsTotal;

    public double getFundsTotal() {
        return fundsTotal;
    }

    public void setFundsTotal(double fundsTotal) {
        this.fundsTotal = fundsTotal;
    }

    public Treasury(double fundsTotal) {
        this.fundsTotal = fundsTotal;
    }

    @Override
    public String toString() {
        return "Treasury{" +
                "fundsTotal=" + fundsTotal +
                '}';
    }
}
