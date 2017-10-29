package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class Rectangle implements ShapeVisitable {

    private int length;
    private int breadth;

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void accept(ShapeVisitor v) {
        v.visit(this);
    }
}
