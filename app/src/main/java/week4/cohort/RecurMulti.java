
// Cohort Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

package week4.cohort;
import java.lang.Math;


public class RecurMulti {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
        System.out.println(multiply(0,7));
        System.out.println(multiply(4,1));

    }

    public static int multiply(int i, int j) {

        if (i == 1){
            return j;
        }

        if (j == 1){
            return i;
        }

        if (i == 0 || j == 0){
            return 0;
        }

        return j + multiply(i-1, j);
    }

}