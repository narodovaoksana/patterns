package structural.Decorator;

public class UkrainianTranslationDecorator extends LanguageSupportDecorator {
    public UkrainianTranslationDecorator(BankingSoftware bankingSoftware) {
        super(bankingSoftware);
    }

    @Override
    public void displayMenu() {
        super.displayMenu();
        System.out.println("Виберіть опцію:");
        System.out.println("1. Переглянути баланс");
        System.out.println("2. Зробити переказ");
        System.out.println("3. Здійснити платіжну операцію");
        System.out.println("4. Налаштування");
    }
}