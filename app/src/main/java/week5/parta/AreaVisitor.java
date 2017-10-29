package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class AreaVisitor implements ShapeVisitor{
    private float total = 0;

    public float getTotal() {
        return total;
    }

    @Override
    public void visit(Rectangle b) {
        total += b.getBreadth() * b.getLength();
    }

    @Override
    public void visit(Circle c) {
        total += Math.PI * c.getRadius() * c.getRadius();
    }
}
