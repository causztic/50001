package week1.homework;

/**
 * Created by yaojie on 11/9/17.
 */
public class MyRectangle2D {
    double x, y;
    double width, height;

    public MyRectangle2D() {
        this.setHeight(1);
        this.setWidth(1);
        this.setX(0);
        this.setY(0);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return area of rectangle
     */
    public double getArea() {
        return this.height * this.width;
    }

    /**
     * @return perimeter of rectangle
     */
    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }

    /**
     * Checks whether the point given is within the rectangle.
     * The logic here is to check whether the absolute difference between the two points is lesser or equal than half
     * of the height/width.
     * @param x
     * @param y
     * @return
     */
    public boolean contains(double x, double y) {
        return (Math.abs(this.x - x) <= this.width / 2) &&
                (Math.abs(this.y - y) <= this.height / 2);
    }

    /**
     * Checks whether the rectangle contains the input rectangle.
     * @param r2d
     * @return
     */
    public boolean contains(MyRectangle2D r2d){
        return (r2d.x + r2d.width / 2) <= (this.x + this.width / 2) &&
                (r2d.x - r2d.width / 2) >= (this.x - this.width / 2) &&
                (r2d.y + r2d.height / 2) <= (this.y + this.height / 2) &&
                (r2d.y - r2d.height / 2) >= (this.y - this.height / 2);
    }

    /**
     * Checks whether the rectangle given overlaps the rectangle.
     * @param r2d
     * @return
     */
    public boolean overlaps(MyRectangle2D r2d){
        // we do a reverse check; check that the rectangles don't overlap
        return !((this.x + this.width / 2) < (r2d.x - r2d.width / 2) ||
                (this.y + this.height / 2) < (r2d.y - r2d.height / 2) ||
                (this.x - this.width / 2) > (r2d.x + r2d.width / 2) ||
                (this.y - this.height / 2) > (r2d.y + r2d.height / 2));
    }
}

