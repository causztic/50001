package week4.homework;
// Homework Question 5
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOdds {
        public static void main (String[] args) {
            int number = 10134;
            System.out.println(sumOdd(number));
            }
        
        public static int sumOdd(int i) {
            int num = i % 10;
            if (Math.abs(i) < 10){
                return i;
            }
            if (Math.abs(num % 2) == 1){
                return Math.abs(num) + sumOdd(i / 10);
            }  else {
                return sumOdd(i / 10);
            }
        }
    }
