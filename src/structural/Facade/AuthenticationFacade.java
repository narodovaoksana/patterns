package structural.Facade;

public class AuthenticationFacade {
    private AuthenticationService authService;

    public AuthenticationFacade() {
        this.authService = new BankAuthenticationService();
    }

    public boolean login(String username, String password) {
        return authService.authenticateUser(username, password);
    }

    public boolean checkAccess(String username, String role) {
        return authService.authorizeUser(username, role);
    }
}
