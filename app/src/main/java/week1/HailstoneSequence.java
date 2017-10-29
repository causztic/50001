package week1;
import java.util.ArrayList;
/**
 * Created by yaojie on 12/9/17.
 */

public class HailstoneSequence {

//    public static int[] arrayHailstone(int n){
//        //this doesn't make sense
//    }

    public static ArrayList<Integer> arrayListHailstone(int n){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(n);
        while (n != 1){
            if (n % 2 == 0){
                n = n / 2;
            } else {
                n = 3*n + 1;
            }
            result.add(n);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(arrayListHailstone(3));
    }
}
