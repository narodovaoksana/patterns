package behavioral.Visitor;

public interface Visitor {
    void visit(Loan loan);

    void visit(Deposit deposit);
}