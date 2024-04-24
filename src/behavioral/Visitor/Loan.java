package behavioral.Visitor;

public class Loan extends FinancialProduct {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // Додаткові методи та логіка, що стосуються кредитів
    public void offerLoanTerms() {
        System.out.println("Offering loan terms...");
    }
}
