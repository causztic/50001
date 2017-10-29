package week1.homework;

/**
 * Created by yaojie on 11/9/17.
 */
public class TestChecker {
    public static void main(String[] args) {
        int[] items = { 4, 7, 14, 23, 99 };
        for (int item: items){
            System.out.printf("%d \t", PrimeNumberChecker.primeNumberChecker(item));
        }
        System.out.println();

        MyRectangle2D a = new MyRectangle2D();
        System.out.println(a.getX()); //Expected Output: 0


        a = new MyRectangle2D();
        String ans = a.getX() + ", " + a.getY() + ", " + a.getWidth() + ", " + a.getHeight() + ", " + a.getPerimeter() + ", " + a.getArea();
        System.out.println(ans); // Expected Output: 0.0, 0.0, 1.0, 1.0, 4.0, 1.0

        a = new MyRectangle2D(1, 2, 3, 4);
        ans = a.getX() + ", " + a.getY() + ", " + a.getWidth() + ", " + a.getHeight() + ", " + a.getPerimeter() + ", " + a.getArea();
        System.out.println(ans); // Expected Output: 1.0, 2.0, 3.0, 4.0, 14.0, 12.0

        MyRectangle2D b = new MyRectangle2D(10, 20, 60, 20);
        ans = "" + b.contains(-18, 12);
        System.out.println(ans); //  Expected Output: true


        b = new MyRectangle2D(10, 20, 60, 20);
        ans = "" + b.contains(new MyRectangle2D(-10, 22, 5, 4));
        System.out.println(ans); // Expected Output: true

        b = new MyRectangle2D(10, 20, 60, 20);
        ans = "" + b.contains(new MyRectangle2D(-10, 22, 22, 4));
        System.out.println(ans); // Expected Output: false

        b = new MyRectangle2D(10, 20, 60, 20);
        ans = "" + b.overlaps(new MyRectangle2D(-32, 22, 22, 4));
        System.out.println(ans); // Expected Output: false
    }
}
