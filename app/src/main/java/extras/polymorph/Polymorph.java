package extras.polymorph;

import java.util.*;

/**
 * Created by yaojie on 21/9/17.
 */

public class Polymorph {

    static void compareColor(Shape s, Shape s2){
        System.out.printf("Comparing %s with %s", s.getColor(), s2.getColor());
    }

    public static void main(String[] args){
        Shape c = new Circle();
        Shape t = new Triangle();
        compareColor(c, t);
        List<Shape> l = new ArrayList<>();
        l.add(c);
        l.add(t);

    }
}
