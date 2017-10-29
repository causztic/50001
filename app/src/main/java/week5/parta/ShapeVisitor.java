package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public interface ShapeVisitor {
    void visit(Rectangle b);
    void visit(Circle c);
}
