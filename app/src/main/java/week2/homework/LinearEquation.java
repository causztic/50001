package week2.homework;

// Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.Scanner;

class LinearEquation {
    // ax + by = e
    // cx + dy = f

    private double a,b,c,d,e,f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable(){
        return (a*d-b*c != 0);
    }

    // Cramer's Rule
    public double getX(){
        return (e*d-b*f)/(a*d-b*c);
    }

    public double getY(){
        return (a*f-e*c)/(a*d-b*c);
    }

    public static void main(String[] args) {
//        double a = 1.0;
//        double b = 2.0;
//        double c = 3.0;
//        double d = 5.0;
//        double e = 6.0;
//        double f = 7.0;
//        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
//        if (equation.isSolvable()) {
//            System.out.println("x is " + equation.getX() + " and y is " + equation.getY());
//        } else {
//            System.out.println("The equation has no solution");
//        }
//
//        LinearEquation equation2 = new LinearEquation(1.25, 2.0, 2.0, 4.2, 3.0, 6.0);
//        if (equation2.isSolvable()) {
//            System.out.println("x is " + equation2.getX() + " y is " + equation2.getY());
//        }
//        LinearEquation equation3 = new LinearEquation(1.0, 2.0, 2.0, 4.0, 3.0, 6.0);
//        System.out.println(equation3.isSolvable());
        Scanner sc = new Scanner(System.in);
        char[] items = {'a', 'b', 'c', 'd', 'e', 'f'};
        double[] values = new double[items.length];
        for (int i = 0; i < items.length; i++){
            System.out.printf("Enter a value for %s: \t", items[i]);
            values[i] = sc.nextDouble();
        }
        LinearEquation equation = new LinearEquation(values[0], values[1], values[2], values[3], values[4], values[5]);
        if (equation.isSolvable()) {
            System.out.println("x is " + equation.getX() + " and y is " + equation.getY());
        } else {
            System.out.println("The equation has no solution");
        }
    }
}


//===============================================
// test case
//===============================================

/*

Input:

a = 1.0, b = 2.0, c = 3.0, d = 5.0, e = 6.0, f= 7.0

Expected Output: x is -16.0 and y is 11.0


Input: 

a = 1.25, b = 2.0, c = 2.0, d = 4.2, e = 3.0, f= 6.0

Expected Output: x is 0.48000000000000115 y is 1.2


Input: 

a = 1.0, b = 2.0, c = 2.0, d = 4.0, e = 3.0, f= 6.0

Expected Output: The equation has no solution

*/

