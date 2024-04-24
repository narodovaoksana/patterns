package behavioral.Template_method;

public class LoanInterestCalculator extends FinancialCalculator {
    @Override
    protected double performCalculation() {
        // Логіка розрахунку відсоткової ставки для кредиту
        double principal = 10000; // Сума кредиту
        double rate = 0.05; // Річна відсоткова ставка
        int years = 5; // Тривалість кредиту в роках
        return principal * rate * years;
    }
}
