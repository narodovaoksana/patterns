package behavioral.Template_method;

public class AccountFeeCalculator extends FinancialCalculator {
    @Override
    protected double performCalculation() {
        // Логіка розрахунку комісії за обслуговування рахунку
        double balance = 5000; // Баланс рахунку
        double feeRate = 0.02; // Відсоткова ставка комісії
        return balance * feeRate;
    }
}
