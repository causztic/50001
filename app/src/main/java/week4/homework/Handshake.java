package week4.homework;
// Homework Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.InputMismatchException;

public class Handshake {
    public static void main (String[] args) {
        try {
         
            System.out.println(handshake(10));
            System.out.println(handshake(3));
            System.out.println(handshake(-4));

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static int handshake (int k) throws InputMismatchException {
        if (k < 0)
            throw new InputMismatchException("Sorry. Number of persons cannot be negative.");
        if (k == 0 || k == 1)
            return 0;

        if (k == 2)
            return 1;

        return k * handshake(k-1)/(k-2);
    }
}
