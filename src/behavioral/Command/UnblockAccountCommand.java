package behavioral.Command;

public class UnblockAccountCommand implements Command {
    private Account account;

    public UnblockAccountCommand(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.unblock();
        System.out.println("Account " + account.getAccountNumber() + " unblocked");
    }
}