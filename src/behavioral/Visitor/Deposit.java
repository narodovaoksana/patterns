package behavioral.Visitor;

public class Deposit extends FinancialProduct {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // Додаткові методи та логіка, що стосуються депозитів
    public void offerDepositTerms() {
        System.out.println("Offering deposit terms...");
    }
}
