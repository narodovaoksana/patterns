package behavioral.Visitor;

public abstract class FinancialProduct {
    // Метод прийому відвідувача
    public abstract void accept(Visitor visitor);
}
