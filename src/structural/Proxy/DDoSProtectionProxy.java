package structural.Proxy;

import java.util.ArrayList;
import java.util.List;

public class  DDoSProtectionProxy implements BankingService {
    private BankingService bankingService;
    private List<String> allowedIPs;

    public DDoSProtectionProxy(BankingService bankingService) {
        this.bankingService = bankingService;
        this.allowedIPs = new ArrayList<>();
        allowedIPs.add("192.168.0.1");
        allowedIPs.add("192.168.0.2");
    }
    @Override
    public void processRequest(String request) {
        String clientIP = getClientIPFromRequest(request);
        if (allowedIPs.contains(clientIP)) {
            bankingService.processRequest(request);
        } else {
            System.out.println("DDoS атака виявлена. Запит з IP-адреси " + clientIP + " заблоковано.");
        }
    }
        private String getClientIPFromRequest(String request) {
        return "192.168.0.3";
    }
}

