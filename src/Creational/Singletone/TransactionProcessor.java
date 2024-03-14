package Creational.Singletone;

import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {
    private static TransactionProcessor instance;
    private List<Transaction> transactions;

    private TransactionProcessor() {
        transactions = new ArrayList<>();
    }

    public static synchronized TransactionProcessor getInstance() {
        if (instance == null) {
            instance = new TransactionProcessor();
        }
        return instance;
    }

    public void processTransaction(Transaction transaction) {
        transactions.add(transaction);
        anylyzeTransaction(transaction);
    }

    private void anylyzeTransaction(Transaction transaction) {
        if (transaction.getAmount() > 10000) {
            System.out.println("Suspicious transaction detected: " + transaction.getDescription());
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
