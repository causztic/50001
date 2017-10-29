package week5.cohort;

/**
 * Created by yaojie on 12/10/17.
 */

public class Chocolate implements Visitable{

    private double price;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Chocolate(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
