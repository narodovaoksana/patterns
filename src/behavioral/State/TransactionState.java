package behavioral.State;

public interface TransactionState {
    void processTransaction(TransactionContext context);
}
