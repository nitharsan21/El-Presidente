package Ressources;

public class Agriculture {
    private double cumulative;

    public Agriculture(double cumulative) {
        this.cumulative = cumulative;
    }

    public double getCumulative() {
        return cumulative;
    }

    public void setCumulative(double cumulative) {
        if(cumulative<0){
            this.cumulative = 0;
        }else {
            this.cumulative = cumulative;
        }
    }

    @Override
    public String toString() {
        return "Agriculture{" +
                "cumulative=" + cumulative +
                '}';
    }

}
