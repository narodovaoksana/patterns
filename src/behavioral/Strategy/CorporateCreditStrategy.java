package behavioral.Strategy;

public class CorporateCreditStrategy implements CreditStrategy {
    @Override
    public void applyCredit(CreditApplicant applicant) {
        System.out.println("Corporate Credit Strategy applied for " + applicant.getName());
        // Логіка надання кредиту корпоративним клієнтам
    }
}
