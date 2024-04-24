package behavioral.Observer;

public class BankClient implements TransactionObserver {
    private String name;

    public BankClient(String name) {
        this.name = name;
    }

    @Override
    public void update(BankTransaction transaction) {
        System.out.println("Notification for client " + name + ": New transaction - " +
                transaction.getDescription() + ", Amount: " + transaction.getAmount());
    }
}

