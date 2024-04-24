package behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class CreditMediator {
private List<Client> clients;

public CreditMediator() {
    this.clients = new ArrayList<>();
}

// Реєстрація клієнта в системі кредитування
public void registerClient(Client client) {
    clients.add(client);
}

// Оцінка кредитної спроможності клієнта
public boolean assessCreditRating(Client client) {
    // Логіка оцінки кредитної спроможності
    double creditRating = client.getCreditRating();
    return creditRating >= 600; // Приклад: клієнт може отримати кредит, якщо кредитний рейтинг більше або рівний 600
}

// Надання кредиту клієнту з певними умовами
public void provideCredit(Client client, double amount, int durationMonths, double interestRate) {
    if (clients.contains(client) && assessCreditRating(client)) {
        System.out.println("Credit approved for client: " + client.getName());
        System.out.println("Amount: " + amount);
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println();
    } else {
        System.out.println("Credit application declined for client: " + client.getName());
        System.out.println();
    }
}
}
