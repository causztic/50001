package week1.activities;
// Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return getMonthlyInterestRate() * balance / 100;
    }

    public void withdraw(double amount){
        setBalance(balance - amount);
    }

    public void deposit(double amount){
        setBalance(balance + amount);
    }
}

//===============================================
// test case
//===============================================

/*

public class TestAccount{
  public static void main (String[] args) {
    week1.week2.activities.Account account = new week1.week2.activities.Account(1122, 20000);
    week1.week2.activities.Account.setAnnualInterestRate(4.5);

    account.withdraw(2500);
    account.deposit(3000);
    System.out.println("Balance is " + account.getBalance());
    System.out.println("Monthly interest is " +
      account.getMonthlyInterest());
  }
}

Expected output

Balance is 20500.0
Monthly interest is 76.875

*/

