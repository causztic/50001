package week1.activities;
import java.util.Arrays;
import java.util.List;
// Question 3
// total: 5 points

public class IteratingExamples_foreach {

    public static int Act2ForEach(List<Integer> integers) {
        int result = 0;
        for (Integer i : integers) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Act2ForEach(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
    }

}


//===============================================
// test case
//===============================================

/*

Input: (1, 2, 3, 4, 5)

Expected Output: 15

Input: (1, 2, 3, 4, 5, 10)

Expected Output: 25

Input: (1, 10, 100)

Expected Output: 111

*/

