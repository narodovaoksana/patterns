package structural.Proxy;

public class ConcreteBankingService implements BankingService {
    @Override
    public void processRequest(String request) {
        System.out.println("Обробка запиту: " + request);
    }
}
