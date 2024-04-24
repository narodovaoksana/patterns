package behavioral.Strategy;

public class SmallBusinessCreditStrategy implements CreditStrategy {
    @Override
    public void applyCredit(CreditApplicant applicant) {
        System.out.println("Small Business Credit Strategy applied for " + applicant.getName());
        // Логіка надання кредиту малим підприємствам
    }
}

