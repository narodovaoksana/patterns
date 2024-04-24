package behavioral.Command;

public class BankingSystem {
    public void executeCommand(Command command) {
        command.execute();
    }
}