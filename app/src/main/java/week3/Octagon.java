package week3;// Question 1
// total: 10 points

//===============================================
// todo: Modify Octagon class to implement the Comparable<Octagon> interface
//===============================================


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(@NonNull Octagon octagon) {
        return (int)(side - octagon.side);
    }

    public static void main(String[] args) {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l);
        for (Octagon o:l)
            System.out.println(o.getSide());
    }
}

