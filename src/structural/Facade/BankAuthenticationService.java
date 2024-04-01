package structural.Facade;

public class BankAuthenticationService implements AuthenticationService {
    @Override
    public boolean authenticateUser(String username, String password) {
                return true;
    }

    @Override
    public boolean authorizeUser(String username, String role) {

        return true;
    }
}
