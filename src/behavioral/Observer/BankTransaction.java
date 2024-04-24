package behavioral.Observer;

public class BankTransaction {
    private String description;
    private double amount;

    public BankTransaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}