package week1.homework;

/**
 * Created by yaojie on 11/9/17.
 */

public class PrimeNumberChecker {

    /**
     * A function to check whether the number input is a prime number or not.
     *
     * @param number
     * @return a 0 if it is not a prime number, 1 if it is.
     */
    static int primeNumberChecker(int number) {
        int counter = 2;
        int isPrime = 1;
        while (counter < number) {
            if (number % counter == 0) {
                isPrime = 0;
                break;
            }
            counter++;
        }
        return isPrime;
    }
}
