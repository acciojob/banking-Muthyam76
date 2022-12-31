package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        double max = 1 * Math.pow(10, digits);
        double min = 1 * Math.pow(10, digits - 1);
       // System.out.println(min);
        //System.out.println(max);
        boolean flag = false;

        for (int i = (int)min; i < (int)max; i++) {
            int quote = i;
            int total = 0;
            while (quote > 0) {
                int rem = quote % 10;
                quote = quote / 10;
                total = total + rem;
            }
            //System.out.println(total);

            if (total == sum) {
                flag = true;
                System.out.println(i);
                return (int)i + "";

            }
        }
        try {
            if (flag == false)
                throw new Exception("Account Number can not be generated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (amount > balance && (balance - amount) < minBalance)
            throw new Exception("Insufficient Balance");
        else {
            balance = balance - amount;
        }

    }

    public double getBalance() {
        return balance;
    }
//i
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

