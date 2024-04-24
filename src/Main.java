import Creational.Buider.BankAccount;
import Creational.Factory.abs.Card;
import Creational.Factory.abs.CardFactory;
import Creational.Factory.abs.DebitCreditFactory;
import Creational.Factory.method.*;
import Creational.Prototype.Client;
import Creational.Singletone.Transaction;
import Creational.Singletone.TransactionProcessor;
import behavioral.CoR.*;
import behavioral.Command.*;
import behavioral.Iterator.Bank;
import behavioral.Iterator.BankBranch;
import behavioral.Iterator.BankBranchIterator;
import behavioral.Iterator.Iterator;
import behavioral.Mediator.CreditMediator;
import behavioral.Visitor.*;
import behavioral.Memento.BankingApp;
import behavioral.Memento.SessionCaretaker;
import behavioral.Observer.BankClient;
import behavioral.Observer.BankTransaction;
import behavioral.Observer.TransactionNotificationSystem;
import behavioral.State.CanceledState;
import behavioral.State.CompletedState;
import behavioral.State.FailedState;
import behavioral.State.TransactionContext;
import behavioral.Strategy.*;
import behavioral.Template_method.AccountFeeCalculator;
import behavioral.Template_method.FinancialCalculator;
import behavioral.Template_method.LoanInterestCalculator;
import structural.Adapter.ChatBot;
import structural.Adapter.ChatBotAdapter;
import structural.Adapter.ClientInterface;
import structural.Adapter.WebPortalClient;
import structural.Bridge.*;
import structural.Composite.BankComponent;
import structural.Composite.Department;
import structural.Composite.Subdivision;
import structural.Decorator.BankingSoftware;
import structural.Decorator.BasicBankingSoftware;
import structural.Decorator.LanguageSupportDecorator;
import structural.Decorator.UkrainianTranslationDecorator;
import structural.Facade.AuthenticationFacade;
import structural.Flyweight.TransactionAttributes;
import structural.Flyweight.TransactionAttributesFactory;
import structural.Proxy.BankingService;
import structural.Proxy.ConcreteBankingService;
import structural.Proxy.DDoSProtectionProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Singleton begin----------");
        TransactionProcessor processor = TransactionProcessor.getInstance();
        Transaction transaction1 = new Transaction(5000, "Purchase");
        Transaction transaction2 = new Transaction(12000, "Money transfer");
        processor.processTransaction(transaction1);
        processor.processTransaction(transaction2);

        List<Transaction> allTransactions = processor.getTransactions();
        System.out.println("All transactions: " + allTransactions.size());
        System.out.println("----------Singleton end----------");
        System.out.println();
        System.out.println("----------Prototype begin----------");

        Client client = new Client("Oksana Narodova", 101);
        Client clientClone = (Client) client.doClone();

        if (client != clientClone) {
            System.out.println("Objects are not the same! Yeah!");
        }

        if (client.equals(clientClone)) {
            System.out.println("Objects are identical! Yeah!");
        }

        client.displayInfo();
        clientClone.displayInfo();

        System.out.println("----------Prototype end----------");
        System.out.println("----------Builder begin----------");
        BankAccount bankAccount = new BankAccount.BankAccountBuilder()
                .setAccountNumber("987654321")
                .setOwnerName("Oksana Narodova")
                .setEmail("oksana.narodova@example.com")
                .setBalance(5000.0)
                .setCurrency("USD")
                .setAccountManager("John Smith")
                .setTransactionLimit(1000.0)
                .setInsurance(false)
                .build();
        System.out.println("----------Builder end----------");
        System.out.println();
        System.out.println(bankAccount);
        System.out.println("----------Factory begin----------");
        CardTypeFactory cardTypeFactory = new CardTypeFactory() {
            @Override
            public BankCard makeCard(CardType cardType) {
                switch (cardType) {
                    case VISA:
                        return new Visa();
                    case MASTERCARD:
                        return new Mastercard();
                    case AMEX:
                        return new Amex();
                    default:
                        return null;
                }
            }
        };
        BankCard visa = cardTypeFactory.makeCard(CardType.VISA);
        BankCard mastercard = cardTypeFactory.makeCard(CardType.MASTERCARD);
        BankCard amex = cardTypeFactory.makeCard(CardType.AMEX);
        List<BankCard> cards = new ArrayList<>();
        cards.add(visa);
        cards.add(mastercard);
        cards.add(amex);
        cards.forEach((card) -> {
            card.deposit(100);
            card.withdraw(50);
        });
        System.out.println("----------Factory end----------");
        System.out.println("----------Abstract factory begin----------");
        DebitCreditFactory debitCreditFactory = new DebitCreditFactory();
        CardFactory debitCardFactory = debitCreditFactory.createCardFactory(Creational.Factory.abs.CardType.DEBIT);
        CardFactory creditCardFactory = debitCreditFactory.createCardFactory(Creational.Factory.abs.CardType.CREDIT);
        Card debitCard = debitCardFactory.createCard(100, 0);
        Card creditCard = creditCardFactory.createCard(0, 1000);
        List<Card> cards1 = new ArrayList<>();
        cards1.add(debitCard);
        cards1.add(creditCard);
        cards1.forEach((card) -> {
            card.charge(50);
            System.out.println("Card balance: " + card.checkBalance());
        });
        System.out.println("----------Abstract factory end----------");
        System.out.println("----------Bridge begin----------");
        Currency usd = Currency.USD;
        Currency euro = Currency.EUR;
        Currency uah = Currency.UAH;

        CurrencyConverter usdConverter = new USDConverter();
        CurrencyConverter euroConverter = new EuroConverter();
        CurrencyConverter uahConverter = new UAHConverter();

        CurrencyExchange usdExchange = new USDCurrencyExchange(usd, usdConverter);
        CurrencyExchange euroExchange = new UAHCurrencyExchange(euro, euroConverter);
        CurrencyExchange uahExchange = new UAHCurrencyExchange(uah, uahConverter);
        CurrencyExchange euroExchange1 = new UAHCurrencyExchange(usd, usdConverter);


        euroExchange.exchange(100, Currency.USD);
        uahExchange.exchange(100, Currency.USD);
        uahExchange.exchange(100, Currency.EUR);
        System.out.println("----------Bridge end----------");
        System.out.println("----------Adapter begin----------");
        ClientInterface webPortalClient = new WebPortalClient();
        webPortalClient.communicate();

        ChatBot chatBot = new ChatBot();
        ClientInterface chatBotAdapter = new ChatBotAdapter(chatBot);
        chatBotAdapter.communicate();
        System.out.println("----------Adapter end----------");
        System.out.println("----------Composite begin----------");
        BankComponent frontOffice = new Department("Фронт-офіс");
        BankComponent backOffice = new Department("Бек-офіс");
        BankComponent itDepartment = new Department("IT відділ");
        BankComponent hrDepartment = new Department("HR відділ");
        BankComponent marketingDepartment = new Department("Маркетинговий відділ");

        BankComponent headOffice = new Subdivision("Головний офіс");
        ((Subdivision) headOffice).addComponent(frontOffice);
        ((Subdivision) headOffice).addComponent(backOffice);
        ((Subdivision) headOffice).addComponent(itDepartment);
        ((Subdivision) headOffice).addComponent(hrDepartment);

        BankComponent regionalOffice = new Subdivision("Регіональний офіс");
        BankComponent regionalFrontOffice = new Department("Фронт-офіс Регіонального відділення");
        ((Subdivision) regionalOffice).addComponent(regionalFrontOffice);
        ((Subdivision) regionalOffice).addComponent(marketingDepartment);

        ((Subdivision) headOffice).addComponent(regionalOffice);

        System.out.println("Організаційна структура банку:");
        headOffice.displayInfo();
        System.out.println("----------Composite end----------");
        System.out.println("----------Decorator begin ----------");
        BankingSoftware basicSoftware = new BasicBankingSoftware();
        BankingSoftware languageSupportSoftware = new LanguageSupportDecorator(basicSoftware);
        BankingSoftware ukrainianSoftware = new UkrainianTranslationDecorator(languageSupportSoftware);
        ukrainianSoftware.displayMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть опцію:");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Ви обрали: Переглянути баланс");
                break;
            case 2:
                System.out.println("Ви обрали: Зробити переказ");
                break;
            case 3:
                System.out.println("Ви обрали: Здійснити платіжну операцію");
                break;
            case 4:
                System.out.println("Ви обрали: Налаштування");
                break;
            case 5:
                System.out.println("Ви обрали: Змінити мову");
                break;
            default:
                System.out.println("Невідома опція");
                scanner.close();
        }

        System.out.println("----------Decorator end ----------");
        System.out.println("----------Facade begin ----------");
        AuthenticationFacade authenticationFacade = new AuthenticationFacade();
        String username = "user123";
        String password = "password123";
        if (authenticationFacade.login(username, password)) {
            System.out.println("Користувач " + username + " успішно автентифікований");
            String role = "admin";
            if (authenticationFacade.checkAccess(username, role)) {
                System.out.println("Користувачу " + username + " надано доступ до ресурсу з роллю " + role);
            } else {
                System.out.println("У користувача " + username + " немає доступу до ресурсу з роллю " + role);
            }
        } else {
            System.out.println("Невдача автентифікації для користувача " + username);
        }
        System.out.println("----------Facade end ----------");
        System.out.println("----------Flyweight begin ----------");
        TransactionAttributes transaction3 = TransactionAttributesFactory.getTransactionAttributes(100.0, "2024-03-30", "депозит");
        TransactionAttributes transaction4 = TransactionAttributesFactory.getTransactionAttributes(200.0, "2024-03-30", "зняття");
        TransactionAttributes transaction5 = TransactionAttributesFactory.getTransactionAttributes(100.0, "2024-03-31", "депозит");


        System.out.println("Транзакція 1:");
        System.out.println("Сума: " + transaction3.getAmount());
        System.out.println("Дата: " + transaction3.getDate());
        System.out.println("Тип: " + transaction3.getType());

        System.out.println("\nТранзакція 2:");
        System.out.println("Сума: " + transaction4.getAmount());
        System.out.println("Дата: " + transaction4.getDate());
        System.out.println("Тип: " + transaction4.getType());

        System.out.println("\nТранзакція 3:");
        System.out.println("Сума: " + transaction5.getAmount());
        System.out.println("Дата: " + transaction5.getDate());
        System.out.println("Тип: " + transaction5.getType());
        System.out.println("----------Flyweight end ----------");
        System.out.println("----------Proxy begin ----------");
        BankingService realService = new ConcreteBankingService();
        BankingService proxyService = new DDoSProtectionProxy(realService);
        proxyService.processRequest("Деякі банківські запити");
        System.out.println("----------Proxy end ----------");
        System.out.println("----------CoR start ----------");
        TransactionHandler authorizationHandler = new AuthorizationHandler();
        TransactionHandler suspiciousTransactionHandler = new SuspiciousTransactionHandler();
        TransactionHandler transactionLoggingHandler = new TransactionLoggingHandler();

        // Налаштування ланцюжка обробників
        authorizationHandler.setNextHandler(suspiciousTransactionHandler);
        suspiciousTransactionHandler.setNextHandler(transactionLoggingHandler);

        // Створення тестового запиту на обробку транзакції
        TransactionRequest request1 = new TransactionRequest(5000, "123456789");
        TransactionRequest request2 = new TransactionRequest(15000, "987654321");

        // Обробка тестових запитів
        authorizationHandler.processRequest(request1);

        authorizationHandler.processRequest(request2);
        System.out.println("----------CoR end ----------");
        System.out.println("-----------Comand start-------------");
        Account account1 = new Account("123456789", 1000);
        Account account2 = new Account("987654321", 2000);

        Command transferCommand = new TransferMoneyCommand(account1, account2, 500);
        Command withdrawCommand = new WithdrawMoneyCommand(account1, 200);
        Command depositCommand = new DepositMoneyCommand(account2, 1000);
        Command blockCommand = new BlockAccountCommand(account1);
        Command unblockCommand = new UnblockAccountCommand(account1);

// Створення банківської системи
        BankingSystem bankingSystem = new BankingSystem();

        bankingSystem.executeCommand(transferCommand);
        bankingSystem.executeCommand(withdrawCommand);
        bankingSystem.executeCommand(depositCommand);
        bankingSystem.executeCommand(blockCommand);
        bankingSystem.executeCommand(unblockCommand);

        System.out.println("-----------Comand end-------------");
        System.out.println("-----------Iterator start-------------");
        // Створення банку та його філій
        Bank bank = new Bank();
        bank.addBranch(new BankBranch("Головний відділ", "вул. Головна, 123", "123-456-7890"));
        bank.addBranch(new BankBranch("Відділення в центрі", "вул. Центральна, 456", "456-789-0123"));
        bank.addBranch(new BankBranch("Підсобний відділ", "вул. Підсобна, 789", "789-012-3456"));

        // Використання ітератора для перегляду філій банку
        BankBranchIterator iterator = bank.createIterator();
        while (iterator.hasNext()) {
            BankBranch branch = iterator.next();
            System.out.println("Назва філії: " + branch.getBranchName());
            System.out.println("Адреса: " + branch.getBranchAddress());
            System.out.println("Номер телефону: " + branch.getPhoneNumber());
            System.out.println();
        System.out.println("-------------Iterator end----------------");
        System.out.println("------------Memento start----------------");
        BankingApp bankingApp = new BankingApp();
        bankingApp.updateSession("Oliynik_A", "24.04.2024");

        // Створення та збереження знімка
        SessionCaretaker caretaker = new SessionCaretaker();
        caretaker.saveSessionState(bankingApp.getSessionState());

        // Симуляція вимкнення та перезавантаження додатку
        bankingApp = new BankingApp();

        // Відновлення сесії за допомогою збереженого знімка
        bankingApp.restoreSession(caretaker.restoreLastSessionState());

        // Відображення інформації про сесію
        bankingApp.displaySessionInfo();
        System.out.println("------------Memento end----------------");
        System.out.println("-------Observer start----------------------");
        TransactionNotificationSystem notificationSystem = new TransactionNotificationSystem();

        // Створення клієнтів-спостерігачів
        BankClient client1 = new BankClient("John Doe");
        BankClient client2 = new BankClient("Jane Smith");

        // Підписка клієнтів на сповіщення
        notificationSystem.subscribe(client1);
        notificationSystem.subscribe(client2);

        // Симуляція нових транзакцій
        BankTransaction transaction11 = new BankTransaction("Payment received", 1000);
        BankTransaction transaction12 = new BankTransaction("Withdrawal", 500);
        BankTransaction transaction13 = new BankTransaction("Online purchase", 200);

        // Сповіщення про нові транзакції
        notificationSystem.notifyObservers(transaction11);
        notificationSystem.notifyObservers(transaction12);
        notificationSystem.notifyObservers(transaction13);

        // Відписка одного з клієнтів від сповіщень
        notificationSystem.unsubscribe(client2);

        // Ще одна транзакція
        BankTransaction transaction14 = new BankTransaction("Deposit", 1500);
        notificationSystem.notifyObservers(transaction14);
        System.out.println("------------Observer end-----------------");
        System.out.println("--------------State start---------------");
        // Створення контексту транзакції
        TransactionContext context = new TransactionContext();

        // Виконання транзакції у стані "В очікуванні"
        context.processTransaction();

        // Зміна стану на "Успішно виконано" і повторне виконання транзакції
        context.setState(new CompletedState());
        context.processTransaction();

        // Зміна стану на "Неуспішно виконано" і повторне виконання транзакції
        context.setState(new FailedState());
        context.processTransaction();

        // Зміна стану на "Скасовано" і повторне виконання транзакції
        context.setState(new CanceledState());
        context.processTransaction();

        System.out.println("-------------State end---------------");
        System.out.println("---------------Strategy start--------------");
        CreditManager creditManager = new CreditManager();

        // Встановлення стратегії кредитування для корпоративних клієнтів
        creditManager.setCreditStrategy(new CorporateCreditStrategy());
        creditManager.applyCredit(new CreditApplicant("ABC Corporation"));

        // Встановлення стратегії кредитування для малих підприємств
        creditManager.setCreditStrategy(new SmallBusinessCreditStrategy());
        creditManager.applyCredit(new CreditApplicant("XYZ Small Business"));

        // Встановлення стратегії кредитування для фізичних осіб
        creditManager.setCreditStrategy(new IndividualCreditStrategy());
        creditManager.applyCredit(new CreditApplicant("John Doe"));
        System.out.println("---------------Strategy end--------------");
        System.out.println("-------------Template method start----------------");
        // Розрахунок відсоткової ставки кредиту
        System.out.println("Loan Interest Calculation:");
        FinancialCalculator loanCalculator = new LoanInterestCalculator();
        loanCalculator.calculate();

        // Розрахунок комісії за обслуговування рахунку
        System.out.println("\nAccount Fee Calculation:");
        FinancialCalculator accountFeeCalculator = new AccountFeeCalculator();
        accountFeeCalculator.calculate();
        System.out.println("---------------Template method end--------------");
        System.out.println("---------------Visitor start--------------");

            // Створення фінансових продуктів
            FinancialProduct loan = new Loan();
            FinancialProduct deposit = new Deposit();

            // Створення відвідувача
            Visitor visitor = new FinancialProductVisitor();

            // Обробка продуктів відвідувачем
            loan.accept(visitor);
            deposit.accept(visitor);
        System.out.println("---------------Visitor end--------------");
    }}}