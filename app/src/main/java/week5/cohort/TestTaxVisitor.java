package week5.cohort;

import java.util.ArrayList;

/**
 * Created by yaojie on 12/10/17.
 */

public class TestTaxVisitor {
    public static void main (String[] args) {

        ArrayList<Visitable> items = new ArrayList<Visitable>();
        TaxVisitor tax = new TaxVisitor("TAXHOLIDAY");

        items.add(new Car(100000));
        items.add(new Electronics(2000));
        items.add(new Chocolate(100));

        for (Visitable o : items) {
            o.accept(tax);
        }
        System.out.println("This is the Tax Visitor program. Total tax: ");
        System.out.println (tax.getTotal());
    }
}
