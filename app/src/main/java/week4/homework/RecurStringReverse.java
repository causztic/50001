package week4.homework;
// Homework Question 7
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.InputMismatchException;

public class RecurStringReverse {
    public static void main (String[] args) {
        System.out.println(recurStringReverse("man ate fish"));
         
        
    }
   public static String recurStringReverse (String s)  {
         // Input your codes here
       int index = s.lastIndexOf(" ");
       if (index != -1){
           return s.substring(index + 1) + " " + recurStringReverse(s.substring(0, index));
       } else {
           return s;
       }
    }
}
