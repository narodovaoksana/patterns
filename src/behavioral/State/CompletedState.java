package behavioral.State;

public class CompletedState implements TransactionState {
    @Override
    public void processTransaction(TransactionContext context) {
        System.out.println("Transaction completed successfully.");
        // Виконати необхідні операції для успішно виконаної транзакції
    }
}
