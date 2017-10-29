package week1.activities;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Question 2
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================


public class IteratingExamples_iterator {

    public static int Act2Iterator(List<Integer> integers) {
        int result = 0;
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ) {
            result += iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5); // this is a fixed size list
        //ArrayList<Integer> alIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // this is a dynamic size list
        System.out.println(Act2Iterator(integers));
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

