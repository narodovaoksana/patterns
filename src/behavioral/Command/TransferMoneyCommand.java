package behavioral.Command;

import behavioral.Command.Account;
import behavioral.Command.Command;

public class TransferMoneyCommand implements Command {
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;

    public TransferMoneyCommand(Account sourceAccount, Account destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);
        System.out.println("Transfer completed: $" + amount + " transferred from " + sourceAccount.getAccountNumber() + " to " + destinationAccount.getAccountNumber());
    }
}

