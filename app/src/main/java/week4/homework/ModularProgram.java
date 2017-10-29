package week4.homework;
// Homework Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class ModularProgram {
    public static void main (String[] args) {

        System.out.println("Welcome to the modulus computer");
        System.out.println("Enter two integer values");

        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        do {
            try {
                tryexception(input);
            }
            catch (InputMismatchException ex)  {
                System.out.println("Sorry, you must enter two integer values");

            }
            catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
            catch (Exception e){
                System.out.println(e);
            }
            finally {
                System.out.println ("Do another pair of values ? (y)");
                input.nextLine();
                if (input.hasNextLine()){
                    String str = input.nextLine();
                    char ch = str.charAt(0);

                    if ((ch != 'y') && (ch != 'Y')) {
                        continueInput = false;
                    }
                }
            }
        } while (continueInput);
    }

    public static void tryexception (Scanner input) throws InputMismatchException, ArithmeticException {

        int x = input.nextInt();
        int y = input.nextInt();

        if (y == 0)
            throw new ArithmeticException("Sorry, cannot compute mod by 0");

        System.out.printf("The value is %d \n", x % y);
    }
}
