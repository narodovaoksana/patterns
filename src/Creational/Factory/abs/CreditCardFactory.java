package Creational.Factory.abs;

public class CreditCardFactory extends CardFactory {
    @Override
    public Card createCard(double balance, double creditLimit) {
        return new CreditCard(balance, creditLimit);
    }
}
