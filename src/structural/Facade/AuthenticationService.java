package structural.Facade;

public interface AuthenticationService {
    boolean authenticateUser(String username, String password);
    boolean authorizeUser(String username, String role);
}