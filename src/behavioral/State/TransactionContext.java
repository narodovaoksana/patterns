package behavioral.State;

public class TransactionContext {
    private TransactionState state;

    public TransactionContext() {
        // Початковий стан транзакції - "В очікуванні"
        this.state = new PendingState();
    }

    // Метод для встановлення нового стану транзакції
    public void setState(TransactionState state) {
        this.state = state;
    }

    // Метод для виконання транзакції залежно від поточного стану
    public void processTransaction() {
        state.processTransaction(this);
    }
}
