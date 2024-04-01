package structural.Bridge;
public class EuroConverter implements CurrencyConverter {
    private static final double EXCHANGE_RATE_TO_USD = 1.18;

    @Override
    public double convert(double amount, Currency toCurrency) {
        if (toCurrency == Currency.USD) {
            return amount * EXCHANGE_RATE_TO_USD;
        } else {
            return amount;
        }
    }
}


