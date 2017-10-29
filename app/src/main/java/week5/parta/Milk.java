package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class Milk implements Visitable{

    private int price;

    public int getPrice() {
        return price;
    }

    public Milk(int price){
        this.price = price;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
