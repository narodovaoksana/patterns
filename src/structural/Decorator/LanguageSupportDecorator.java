package structural.Decorator;

public class LanguageSupportDecorator implements BankingSoftware {
    private BankingSoftware bankingSoftware;

    public LanguageSupportDecorator(BankingSoftware bankingSoftware) {
        this.bankingSoftware = bankingSoftware;
    }

    @Override
    public void displayMenu() {
        bankingSoftware.displayMenu();
        System.out.println("Language options:");
        System.out.println("5. Change language");
    }
}
