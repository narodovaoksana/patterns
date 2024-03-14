package Creational.Factory.method;
import java.util.ArrayList;
import java.util.List;
public class Amex extends BankCard {
    public Amex() {
    }

    public void deposit(double amount) {
        System.out.println("Amex card deposited: " + amount);
    }

    public void withdraw(double amount) {
        System.out.println("Amex card withdrawn: " + amount);
    }
}