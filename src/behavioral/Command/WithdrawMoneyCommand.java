package behavioral.Command;

 // Клас для виконання зняття коштів
public class WithdrawMoneyCommand implements Command {
    private Account account;
    private double amount;

    public WithdrawMoneyCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
        System.out.println("$" + amount + " withdrawn from account " + account.getAccountNumber());
    }
}

