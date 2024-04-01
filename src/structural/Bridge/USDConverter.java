package structural.Bridge;

public class USDConverter implements CurrencyConverter {
    private static final double EXCHANGE_RATE = 1.0;

    @Override
    public double convert(double amount, Currency toCurrency) {
        return (toCurrency == Currency.USD) ? amount : amount * EXCHANGE_RATE;
    }
}