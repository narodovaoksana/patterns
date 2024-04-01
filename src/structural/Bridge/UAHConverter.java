package structural.Bridge;

// Файл UAHConverter.java
public class UAHConverter implements CurrencyConverter {
    private static final double EXCHANGE_RATE_TO_USD = 0.035;
    private static final double EXCHANGE_RATE_TO_EUR = 0.030;

    @Override
    public double convert(double amount, Currency toCurrency) {
        switch (toCurrency) {
            case USD:
                return amount * EXCHANGE_RATE_TO_USD;
            case EUR:
                return amount * EXCHANGE_RATE_TO_EUR;
            default:
                return amount;
        }
    }
}
