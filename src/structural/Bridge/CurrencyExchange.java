package structural.Bridge;

public abstract class CurrencyExchange {
    protected Currency currency;
    protected CurrencyConverter converter;

    public CurrencyExchange(Currency currency, CurrencyConverter converter) {
        this.currency = currency;
        this.converter = converter;
    }

    public abstract double exchange(double amount, Currency toCurrency);
}
