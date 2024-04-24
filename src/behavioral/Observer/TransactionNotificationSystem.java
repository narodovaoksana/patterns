package behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class TransactionNotificationSystem {
    private List<TransactionObserver> observers;

    public TransactionNotificationSystem() {
        this.observers = new ArrayList<>();
    }

    // Метод для підписки на сповіщення
    public void subscribe(TransactionObserver observer) {
        observers.add(observer);
    }

    // Метод для відписки від сповіщень
    public void unsubscribe(TransactionObserver observer) {
        observers.remove(observer);
    }

    // Метод для сповіщення спостерігачів про нову транзакцію
    public void notifyObservers(BankTransaction transaction) {
        for (TransactionObserver observer : observers) {
            observer.update(transaction);
        }
    }
}
