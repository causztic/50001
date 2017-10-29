package week4.cohort;
// Cohort Question 6
// total: 5 points

//===============================================
// todo: complete the following program
//==============================================6


public class DoubleEachLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        String output = doubleEachLetter(s);
        System.out.println("output = " + output);
    }
    public static String doubleEachLetter(String s){
        if (s.length() == 0)
            return "";
        return "" + s.charAt(0) + s.charAt(0) + doubleEachLetter(s.substring(1));
    }
}
