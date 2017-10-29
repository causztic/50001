package extras.polymorph;

import android.support.annotation.NonNull;

/**
 * Created by yaojie on 21/9/17.
 */

class Shape implements Comparable<Shape>{

    private int area = 0;

    String getColor(){
        return "Yellow";
    }

    @Override
    public int compareTo(@NonNull Shape o) {
        return this.area - o.area;
    }
}
