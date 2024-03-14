package structural.Bridge;

public class UAHCurrencyExchange extends CurrencyExchange {
    public UAHCurrencyExchange(Currency currency, CurrencyConverter converter) {
        super(currency, converter);
    }

    @Override
    public double exchange(double amount, Currency toCurrency) {
        System.out.println("Converting " + amount + " " + currency.getName() + " to " + toCurrency.getName());
        double convertedAmount = converter.convert(amount, toCurrency);
        System.out.println("Result: " + convertedAmount + " " + toCurrency.getName());
        return convertedAmount;
    }
}