import Creational.Buider.BankAccount;
import Creational.Factory.abs.*;
import Creational.Factory.method.*;
import Creational.Factory.method.CardType;
import Creational.Singletone.Transaction;
import Creational.Singletone.TransactionProcessor;
import Creational.Prototype.Client;
import structural.Bridge.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Singleton begin----------");
        TransactionProcessor processor = TransactionProcessor.getInstance();
        Transaction transaction1 = new Transaction(5000, "Purchase");
        Transaction transaction2 = new Transaction(12000, "Money transfer");
        processor.processTransaction(transaction1);
        processor.processTransaction(transaction2);

        List<Transaction> allTransactions = processor.getTransactions();
        System.out.println("All transactions: " + allTransactions.size());
        System.out.println("----------Singleton end----------");
        System.out.println();
        System.out.println("----------Prototype begin----------");

        Client client = new Client("Oksana Narodova", 101);
        Client clientClone = (Client) client.doClone();

        if (client != clientClone) {
            System.out.println("Objects are not the same! Yeah!");
        }

        if (client.equals(clientClone)) {
            System.out.println("Objects are identical! Yeah!");
        }

        client.displayInfo();
        clientClone.displayInfo();

        System.out.println("----------Prototype end----------");
        System.out.println("----------Builder begin----------");
        BankAccount bankAccount = new BankAccount.BankAccountBuilder()
                .setAccountNumber("987654321")
                .setOwnerName("Oksana Narodova")
                .setEmail("oksana.narodova@example.com")
                .setBalance(5000.0)
                .setCurrency("USD")
                .setAccountManager("John Smith")
                .setTransactionLimit(1000.0)
                .setInsurance(false)
                .build();
        System.out.println("----------Builder end----------");
        System.out.println();
        System.out.println(bankAccount);
        System.out.println("----------Factory begin----------");
        CardTypeFactory cardTypeFactory = new CardTypeFactory() {
            @Override
            public BankCard makeCard(CardType cardType) {
                switch (cardType) {
                    case VISA:
                        return new Visa();
                    case MASTERCARD:
                        return new Mastercard();
                    case AMEX:
                        return new Amex();
                    default:
                        return null;
                }
            }
        };
        BankCard visa = cardTypeFactory.makeCard(CardType.VISA);
        BankCard mastercard = cardTypeFactory.makeCard(CardType.MASTERCARD);
        BankCard amex = cardTypeFactory.makeCard(CardType.AMEX);
        List<BankCard> cards = new ArrayList<>();
        cards.add(visa);
        cards.add(mastercard);
        cards.add(amex);
        cards.forEach((card) -> {
            card.deposit(100);
            card.withdraw(50);
        });
        System.out.println("----------Factory end----------");
        System.out.println("----------Abstract factory begin----------");
        DebitCreditFactory debitCreditFactory = new DebitCreditFactory();
        CardFactory debitCardFactory = debitCreditFactory.createCardFactory(Creational.Factory.abs.CardType.DEBIT);
        CardFactory creditCardFactory = debitCreditFactory.createCardFactory(Creational.Factory.abs.CardType.CREDIT);
        Card debitCard = debitCardFactory.createCard(100, 0);
        Card creditCard = creditCardFactory.createCard(0, 1000);
        List<Card> cards1 = new ArrayList<>();
        cards1.add(debitCard);
        cards1.add(creditCard);
        cards1.forEach((card) -> {
            card.charge(50);
            System.out.println("Card balance: " + card.checkBalance());
        });
        System.out.println("----------Abstract factory end----------");
        Currency usd = Currency.USD;
        Currency euro = Currency.EUR;
        Currency uah = Currency.UAH;

        CurrencyConverter usdConverter = new USDConverter();
        CurrencyConverter euroConverter = new EuroConverter();
        CurrencyConverter uahConverter = new UAHConverter();

        CurrencyExchange usdExchange = new USDCurrencyExchange(usd, usdConverter);
        CurrencyExchange euroExchange = new UAHCurrencyExchange(euro, euroConverter);
        CurrencyExchange uahExchange = new UAHCurrencyExchange(uah, uahConverter);

        usdExchange.exchange(100, Currency.EUR);
        euroExchange.exchange(100, Currency.USD);
        uahExchange.exchange(100, Currency.USD);
        uahExchange.exchange(100, Currency.EUR);

    }}

