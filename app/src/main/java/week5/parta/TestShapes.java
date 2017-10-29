package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class TestShapes {
    public static void main(String[] args) {
        AreaVisitor av = new AreaVisitor();
        PerimeterVisitor pv = new PerimeterVisitor();
        Circle c = new Circle(10);
        Square s = new Square(4);
        Rectangle r = new Rectangle(2,4);
        av.visit(c);
        av.visit(s);
        av.visit(r);
        pv.visit(c);
        pv.visit(s);
        pv.visit(r);
        System.out.println("Hello World! Testing Geometry Visitor.");
        System.out.println(String.format("Area: %.4f", av.getTotal()));
        System.out.println(String.format("Perimeter: %.4f", pv.getTotal()));
    }
}