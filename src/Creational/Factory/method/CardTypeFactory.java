package Creational.Factory.method;

public abstract class CardTypeFactory {
    public CardTypeFactory() {
    }

    public abstract BankCard makeCard(CardType var1);
}