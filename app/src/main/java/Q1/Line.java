package Q1;


import android.support.annotation.NonNull;

public class Line implements Comparable<Line>{
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(){
        x1 = 0;
        y1 = 0;
        x2 = 1;
        y2 = 1;
    }
    public Line(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    // Computes the slope of the line.
    public double computeSlope(){
        // i dont rmb the slope function lol
        // my comparator function is definitely correct soooooo
        return (y1 - y2)/(x1 - x2);
    }

    // computes the length of the line
    public double computeLength(){
        return Math.sqrt((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));
    }

    @Override
    public String toString() {
        return String.format("Line:(%.1f,%.1f);(%.1f,%.1f)", x1, y1, x2, y2);
    }

    @Override
    public int compareTo(@NonNull Line line) {
        return (int)(computeLength() - line.computeLength());
    }

}
