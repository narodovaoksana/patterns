package behavioral.Visitor;

public class FinancialProductVisitor implements Visitor {
    @Override
    public void visit(Loan loan) {
        System.out.println("Processing loan...");
        loan.offerLoanTerms();
    }

    @Override
    public void visit(Deposit deposit) {
        System.out.println("Processing deposit...");
        deposit.offerDepositTerms();
    }
}
