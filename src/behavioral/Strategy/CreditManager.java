package behavioral.Strategy;

public class CreditManager {
    private CreditStrategy creditStrategy;

    // Встановлення стратегії кредитування
    public void setCreditStrategy(CreditStrategy creditStrategy) {
        this.creditStrategy = creditStrategy;
    }

    // Застосування стратегії кредитування для заявника на кредит
    public void applyCredit(CreditApplicant applicant) {
        creditStrategy.applyCredit(applicant);
    }
}
