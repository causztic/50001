package week5.cohort;

/**
 * Created by yaojie on 12/10/17.
 */

public interface Visitor {
    void visit(Car b);
    void visit(Electronics c);
    void visit(Chocolate c);
}
