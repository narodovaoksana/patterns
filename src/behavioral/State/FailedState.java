package behavioral.State;

public class FailedState implements TransactionState {
    @Override
    public void processTransaction(TransactionContext context) {
        System.out.println("Transaction failed.");
        // Виконати необхідні операції для неуспішно виконаної транзакції
    }
}
