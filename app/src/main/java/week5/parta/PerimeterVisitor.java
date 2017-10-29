package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class PerimeterVisitor implements ShapeVisitor{
    private float total = 0;

    public float getTotal() {
        return total;
    }

    @Override
    public void visit(Rectangle b) {
        total += b.getLength() * 2 + b.getBreadth() * 2;
    }

    @Override
    public void visit(Circle c) {
        total += Math.PI * c.getRadius() * 2;
    }
}
