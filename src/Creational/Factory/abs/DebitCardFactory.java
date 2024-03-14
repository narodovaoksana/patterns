package Creational.Factory.abs;

public class DebitCardFactory extends CardFactory {
    @Override
    public Card createCard(double balance, double creditLimit) {
        return new DebitCard(balance);
    }
}