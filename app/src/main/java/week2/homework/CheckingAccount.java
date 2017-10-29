package week2.homework;

// Question 3
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

import week1.activities.Account;

public class CheckingAccount extends Account {

    public CheckingAccount(){
    }

    public CheckingAccount(int id, double balance){
        super(id, balance);
    }

    @Override
    public void withdraw(double amount){
        if (getBalance() <= -5000) {
            System.out.println("over limit");
        } else {
            super.withdraw(amount);
        }
    }
}

class TestCheckingAccount {

    public static void main(String[] args) {

        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);

        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
    }

}



//===============================================
// test case
//===============================================

/*

Input:




Expected Output: 

-5000.0
over limit
-5000.0
1800.0
*/

