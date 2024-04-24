package behavioral.Memento;

public class BankingApp {
private String username;
private String sessionData;

// Метод для оновлення стану сесії
public void updateSession(String username, String sessionData) {
    this.username = username;
    this.sessionData = sessionData;
}

// Метод для отримання стану сесії
public SessionState getSessionState() {
    return new SessionState(username, sessionData);
}

// Метод для відновлення сесії за допомогою знімка
public void restoreSession(SessionState state) {
    this.username = state.getUsername();
    this.sessionData = state.getSessionData();
}

// Метод для відображення інформації про сесію
public void displaySessionInfo() {
    System.out.println("Username: " + username);
    System.out.println("Session Data: " + sessionData);
}
}
