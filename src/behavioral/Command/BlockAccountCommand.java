package behavioral.Command;

public class BlockAccountCommand implements Command {
    private Account account;

    public BlockAccountCommand(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.block();
        System.out.println("Account " + account.getAccountNumber() + " blocked");
    }
}
