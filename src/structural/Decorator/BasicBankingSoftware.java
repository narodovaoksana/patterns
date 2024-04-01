package structural.Decorator;

public class BasicBankingSoftware implements BankingSoftware {
    @Override
    public void displayMenu() {
        System.out.println("Welcome to banking software!");
        System.out.println("1. Check balance");
        System.out.println("2. Transfer funds");
        System.out.println("3. Payment operations");
        System.out.println("4. Settings");
    }
}
