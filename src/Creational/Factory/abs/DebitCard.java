package Creational.Factory.abs;

public class DebitCard extends Card {
    private double balance;

    public DebitCard(double balance) {
        this.balance = balance;
    }

    @Override
    public void charge(double amount) {
        balance -= amount;
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}