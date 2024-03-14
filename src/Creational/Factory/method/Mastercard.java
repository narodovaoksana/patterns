package Creational.Factory.method;

public class Mastercard extends BankCard {
    public Mastercard() {
    }

    public void deposit(double amount) {
        System.out.println("Mastercard deposited: " + amount);
    }

    public void withdraw(double amount) {
        System.out.println("Mastercard withdrawn: " + amount);
    }
}
