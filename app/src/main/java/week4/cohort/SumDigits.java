package week4.cohort;
// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
     public static void main (String[] args) {
         int number = -54321;
         int sum = sumDigits(number);
         System.out.println(sum);
     }
        
        public static int sumDigits(int i) {
            if (i == 0)
                return 0;
            return Math.abs(i % 10) + sumDigits(i / 10);

        }
}
