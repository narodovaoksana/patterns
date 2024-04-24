package behavioral.Memento;

import java.util.ArrayList;
import java.util.List;

public class SessionCaretaker {
    private List<SessionState> sessionStates;

    public SessionCaretaker() {
        this.sessionStates = new ArrayList<>();
    }

    // Зберігання стану сесії
    public void saveSessionState(SessionState state) {
        sessionStates.add(state);
    }

    // Відновлення останнього збереженого стану сесії
    public SessionState restoreLastSessionState() {
        if (!sessionStates.isEmpty()) {
            int lastIndex = sessionStates.size() - 1;
            SessionState lastState = sessionStates.get(lastIndex);
            sessionStates.remove(lastIndex);
            return lastState;
        }
        return null;
    }
}