package week1.activities;
// Question 1
// total: 5 points

public class Fibonacci{
	public static String fibonacci(){
        int f0 = 0;
        int f1 = 1;
        String s = f0 + "," + f1;

        for (int k = 0; k < 18; k++) {
            int f2 = f0 + f1;
            f0 = f1;
            f1 = f2;

            s = s + "," + f2;
        }
        return s;
	}

    public static void main(String[] args){
        String s = fibonacci();
        System.out.println(s);
    }
}



//===============================================
// test case
//===============================================

/*

Expected output

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181

*/


