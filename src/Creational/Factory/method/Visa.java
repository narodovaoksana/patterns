package Creational.Factory.method;

public class Visa extends BankCard {
    public Visa() {
    }

    public void deposit(double amount) {
        System.out.println("Visa card deposited: " + amount);
    }

    public void withdraw(double amount) {
        System.out.println("Visa card withdrawn: " + amount);
    }
}
