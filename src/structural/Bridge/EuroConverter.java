package structural.Bridge;
// Файл EuroConverter.java
public class EuroConverter implements CurrencyConverter {
    private static final double EXCHANGE_RATE_TO_USD = 1.18; // EUR to USD conversion rate
    private static final double EXCHANGE_RATE_TO_EUR = 1 / EXCHANGE_RATE_TO_USD; // USD to EUR conversion rate

    @Override
    public double convert(double amount, Currency toCurrency) {
        if (toCurrency == Currency.USD) {
            return amount / EXCHANGE_RATE_TO_USD;
        }
        return amount;
    }
}

