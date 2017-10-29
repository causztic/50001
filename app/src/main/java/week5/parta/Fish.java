package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class Fish implements Visitable{

    private int price;
    private int weight;

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public Fish(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
