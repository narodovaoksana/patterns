package Creational.Buider;

public class BankAccount {
    private final String accountNumber;
    private final String ownerName;
    private final String email;
    private final double balance;
    private final String currency;
    private final String accountManager;
    private final double transactionLimit;
    private final boolean insurance;

    private BankAccount(BankAccountBuilder builder) {
        this.accountNumber = builder.accountNumber;
        this.ownerName = builder.ownerName;
        this.email = builder.email;
        this.balance = builder.balance;
        this.currency = builder.currency;
        this.accountManager = builder.accountManager;
        this.transactionLimit = builder.transactionLimit;
        this.insurance = builder.insurance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", accountManager='" + accountManager + '\'' +
                ", transactionLimit=" + transactionLimit +
                ", insurance=" + insurance +
                '}';
    }

    public static class BankAccountBuilder {
        private String accountNumber;
        private String ownerName;
        private String email;
        private double balance;
        private String currency;
        private String accountManager;
        private double transactionLimit;
        private boolean insurance;

        public BankAccountBuilder() {
        }

        public BankAccountBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public BankAccountBuilder setOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public BankAccountBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public BankAccountBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public BankAccountBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public BankAccountBuilder setAccountManager(String accountManager) {
            this.accountManager = accountManager;
            return this;
        }

        public BankAccountBuilder setTransactionLimit(double transactionLimit) {
            this.transactionLimit = transactionLimit;
            return this;
        }

        public BankAccountBuilder setInsurance(boolean insurance) {
            this.insurance = insurance;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

}

