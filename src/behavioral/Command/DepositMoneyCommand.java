package behavioral.Command;

public class DepositMoneyCommand implements Command {
    private Account account;
    private double amount;

    public DepositMoneyCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("$" + amount + " deposited to account " + account.getAccountNumber());
    }}
