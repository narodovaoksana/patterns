package structural.Bridge;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    UAH("UAH");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
