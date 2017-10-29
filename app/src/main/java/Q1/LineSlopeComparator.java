package Q1;

import java.util.Comparator;

public class LineSlopeComparator implements Comparator<Line> {

    @Override
    public int compare(Line line, Line t1) {
        return (int)(line.computeSlope() - t1.computeSlope());
    }
}
