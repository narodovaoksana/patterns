package behavioral.CoR;

public class SuspiciousTransactionHandler extends TransactionHandler {
    @Override
    protected boolean canHandle(TransactionRequest request) {
        // Логіка визначення, чи є транзакція підозрілою
        return request.getAmount() > 10000; // Приклад: підозріла транзакція, якщо сума більше 10000
    }

    @Override
    protected void handle(TransactionRequest request) {
        // Логіка обробки підозрілої транзакції
        System.out.println("Suspicious transaction detected for account: " + request.getAccountNumber());
    }
}