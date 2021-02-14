package Ressources;

public class Industry {
    private double cumulative;

    public Industry(double cumulative) {
        this.cumulative = cumulative;
    }

    public double getCumulative() {
        return cumulative;
    }

    public void setCumulative(double cumulative) {
        this.cumulative = cumulative;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "cumulative=" + cumulative +
                '}';
    }
}

