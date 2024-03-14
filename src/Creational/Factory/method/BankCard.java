package Creational.Factory.method;
import java.util.ArrayList;
import java.util.List;

public abstract class BankCard {
    public BankCard() {
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}