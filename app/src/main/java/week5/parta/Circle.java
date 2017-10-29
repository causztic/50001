package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class Circle implements ShapeVisitable{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor v) {
        v.visit(this);
    }
}
