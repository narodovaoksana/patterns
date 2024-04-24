package behavioral.State;

public class CanceledState implements TransactionState {
    @Override
    public void processTransaction(TransactionContext context) {
        System.out.println("Transaction canceled.");
        // Виконати необхідні операції для скасованої транзакції
    }
}
