package structural.Flyweight;

public class TransactionAttributes {
    private double amount;
    private String date;
    private String type;

    public TransactionAttributes(double amount, String date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
