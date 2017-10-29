package week5.cohort;

/**
 * Created by yaojie on 12/10/17.
 */

public class Car implements Visitable {

    private double price;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Car(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
