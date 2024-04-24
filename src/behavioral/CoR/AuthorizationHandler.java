package behavioral.CoR;

public class AuthorizationHandler extends TransactionHandler {
    @Override
    protected boolean canHandle(TransactionRequest request) {
        // Логіка перевірки можливості авторизації транзакції
        return true;
    }

    @Override
    protected void handle(TransactionRequest request) {
        // Логіка авторизації транзакції
        System.out.println("Transaction authorized for account: " + request.getAccountNumber());
    }
}
