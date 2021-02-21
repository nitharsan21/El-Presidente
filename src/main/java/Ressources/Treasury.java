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


    public void addMoneyToTressury(double fund){
        this.fundsTotal += fund;
    }

    public void minusMoneyToTressury(double fund){
        this.fundsTotal -= fund;
    }

    @Override
    public String toString() {
        return "Treasury{" +
                "fundsTotal=" + fundsTotal +
                '}';
    }
}
