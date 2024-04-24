package behavioral.CoR;

public class TransactionRequest {
    private double amount;
    private String accountNumber;

    public TransactionRequest(double amount, String accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}