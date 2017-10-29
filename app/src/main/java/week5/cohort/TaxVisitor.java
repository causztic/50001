package week5.cohort;

/**
 * Created by yaojie on 12/10/17.
 */

public class TaxVisitor implements Visitor {

    private double total = 0;
    private int mode = 0;

    public TaxVisitor(String taxingSystem){
        switch (taxingSystem){
            case "TAXNORMAL":
                mode = 1;
                break;
            case "TAXHOLIDAY":
                mode = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid taxing system.");
        }
    }

    @Override
    public void visit(Car b) {

        total += b.getPrice() * (mode == 1 ? 0.4 : 0.3);
    }

    @Override
    public void visit(Electronics c) {

        total += c.getPrice() * (mode == 1 ? 0.8 : 0.5);
    }

    @Override
    public void visit (Chocolate c) {
        total += c.getPrice() * (mode == 1 ? 0.2 : 0.1);
    }

    public double getTotal () {
        return total;
    }
}
