package Creational.Factory.abs;

public class DebitCreditFactory {
    public CardFactory createCardFactory(CardType type){
        return switch(type){
            case DEBIT -> new DebitCardFactory();
            case CREDIT -> new CreditCardFactory();
        };
    }
}
