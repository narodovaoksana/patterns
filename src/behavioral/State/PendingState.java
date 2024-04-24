package behavioral.State;

public class PendingState implements TransactionState {
    @Override
    public void processTransaction(TransactionContext context) {
        System.out.println("Transaction is pending.");
        // Виконати необхідні операції для транзакції у стані "В очікуванні"
    }
}
