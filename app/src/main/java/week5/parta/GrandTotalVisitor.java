package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class GrandTotalVisitor implements Visitor{

    private int total = 0;

    @Override
    public void visit(Milk b) {
        total += b.getPrice();
    }

    @Override
    public void visit(Jacket c) {
        total += c.getPrice() * 1.2;
    }

    @Override
    public void visit(Fish c) {
        total += c.getPrice() * c.getWeight();

    }

    @Override
    public String toString() {

        return String.format("The grand total is: %d", total);
    }

    public static void main(String[] args) {
        GrandTotalVisitor gtv = new GrandTotalVisitor();
        gtv.visit(new Milk(10));
        gtv.visit(new Jacket(20));
        gtv.visit(new Fish(4,2));
        System.out.println(gtv);
    }
}
