package week4.cohort;
// Cohort Question 1
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.Scanner;

public class TestScores {

    public static void testScores(double[] s) throws IllegalArgumentException {
        for (int i = 0; i < s.length; i++){
            if (s[i] < 0 || s[i] > 100)
                throw new IllegalArgumentException("Element: " + i + " Score: " + s[i]);
        }
    }

    public static void main(String [] args) {
        try {
            double[] values = {1.2,1.3,1,102};
            testScores(values);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Exception: Values cannot be less than 0 or bigger than 100 ");
        }
        System.out.println("Execution continues here");
    }

}
