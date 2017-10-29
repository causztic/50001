package week4.homework;
// Homework Question 6
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class ReverseLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        System.out.println ("Calling reverse: ");
        String output = reverse(s);
        System.out.println("output = " + output);
    }
    public static String reverse(String s){
         // Input your codes here
        if (s.length() == 0)
            return "";
        return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
