package behavioral.CoR;

public class TransactionLoggingHandler extends TransactionHandler {
    @Override
    protected boolean canHandle(TransactionRequest request) {
        // Логіка перевірки, чи потрібно реєструвати транзакцію
        return true; // Приклад: усі транзакції потрібно реєструвати
    }

    @Override
    protected void handle(TransactionRequest request) {
        // Логіка реєстрації транзакції
        System.out.println("Transaction logged for account: " + request.getAccountNumber());
    }
}
