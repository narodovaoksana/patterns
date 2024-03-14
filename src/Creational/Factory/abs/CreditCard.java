package Creational.Factory.abs;

public class CreditCard extends Card {
    private double balance;
    private double creditLimit;

    public CreditCard(double balance, double creditLimit) {
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    @Override
    public void charge(double amount) {
        if (balance + amount > creditLimit) {
            System.out.println("Credit limit exceeded.");
        } else {
            balance += amount;
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}