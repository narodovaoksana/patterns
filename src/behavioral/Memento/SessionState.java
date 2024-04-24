package behavioral.Memento;

public class SessionState {
    private String username;
    private String sessionData;

    public SessionState(String username, String sessionData) {
        this.username = username;
        this.sessionData = sessionData;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionData() {
        return sessionData;
    }
}

