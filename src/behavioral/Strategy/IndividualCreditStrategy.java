package behavioral.Strategy;

public class IndividualCreditStrategy implements CreditStrategy {
    @Override
    public void applyCredit(CreditApplicant applicant) {
        System.out.println("Individual Credit Strategy applied for " + applicant.getName());
        // Логіка надання кредиту фізичним особам
    }
}

